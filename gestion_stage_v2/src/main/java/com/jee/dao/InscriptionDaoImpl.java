package com.jee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.*;


public class InscriptionDaoImpl implements InscriptionDao{
	
	private Connection cnx ;
	private StageDaoImpl sd;
	private StagiaireDaoImpl sid;

	public InscriptionDaoImpl() {
		cnx = SingletonConnection.getInstance().getCnx();	
		sd = new StageDaoImpl();
		sid = new StagiaireDaoImpl();
	}
	
	public int insert(Inscription c) {
	    try {
	        String req = "INSERT INTO INSCRIPTION (ID_INSCRIPTION, DATE_INSCRIPTION, STATUT_INSCRIPTION, CODE_POSITION, CODE_STAGE, NUM_STAGIAIRE) VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?)";
	        PreparedStatement st = cnx.prepareStatement(req);
	        st.setInt(1, c.getId_inscription());
	        st.setString(2, String.valueOf(c.getDate_inscrip())); 
	        st.setString(3, String.valueOf(c.getSatut_inscrip()));
	        st.setString(4, String.valueOf(c.getCode_position()));
	        st.setString(5, String.valueOf(c.getStage().getCode_stage()));
	        st.setString(6, String.valueOf(c.getStagiaire().getNum_stagiaire()));
			System.out.println("INSERT INSCRIPTION DAO------------------>");
	        return st.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	public List<Inscription> selectAll(String cs) {
	    try {
	        String req = "SELECT * FROM INSCRIPTION WHERE CODE_STAGE = ?";
	        PreparedStatement ps = cnx.prepareStatement(req);
	        ps.setString(1, cs);
	        ResultSet rs = ps.executeQuery();
	        List<Inscription> insList = new ArrayList<>();
	        while(rs.next()) {
	            int idInscription = rs.getInt(1);
	            Date dateInscrip = rs.getDate(2);
	            char statutInscrip = rs.getString(3).charAt(0);
	            char codePosition = rs.getString(4).charAt(0);
	            Stage stage = sd.select(rs.getString(5)); // Assuming sd is a StageDAO object
	            Stagiaire stagiaire = sid.select(rs.getString(6)); // Assuming sid is a StagiaireDAO object
	            insList.add(new Inscription(idInscription, stage, stagiaire, dateInscrip, statutInscrip, codePosition));
	        }
	        System.out.println("GET_ALL INSCRIPTION DAO------------------>");
	        return insList;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public int get_last_id() {
	    try {
	        String query = "SELECT MAX(ID_INSCRIPTION) AS last_id FROM INSCRIPTION";
	        PreparedStatement statement = cnx.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int lastId = resultSet.getInt("last_id");
	            System.out.println("Dernier ID inséré : " + lastId);
	            return lastId;
	        } else {
	            return 999;
	        }
	    } catch (Exception e) {
	        System.out.println("Erreur lors de la récupération du dernier ID inséré : " + e.getMessage());
	        return -1; 
	    }
	}

}
