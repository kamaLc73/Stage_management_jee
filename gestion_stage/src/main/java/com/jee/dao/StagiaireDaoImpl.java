package com.jee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Stagiaire;

public class StagiaireDaoImpl implements StagiaireDao{
	
	private Connection cnx ;
	
	public StagiaireDaoImpl() {
		cnx = SingletonConnection.getInstance().getCnx();
	}

	public int insert(Stagiaire s) {
	    try {
	        String req = "INSERT INTO STAGIAIRE (NUM_STAGIAIRE, NOM_STAGIAIRE, PRENOM_STAGIAIRE, SEXE_STAGIAIRE, DNAISS_STAGIAIRE, DIPLO_STAGIAIRE) VALUES ('" + s.getNum_stagiaire() + "', '" 
	                + s.getNom_stagiaire() + "', '" + s.getPrenom_stagiaire() + "', '" + s.getSexe_stagiaire() +"', TO_DATE('" + s.getDnaiss_stagiaire() +"', 'YYYY-MM-DD'), '" + s.getDiplo_stagiaire() +"')" ;
	        Statement st = cnx.createStatement();
    		System.out.println("INSERT STAGIAIRE DAO------------------>");
	        return st.executeUpdate(req);    
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	public Stagiaire select(String code) {
	    try {
	        String req = "SELECT * FROM STAGIAIRE WHERE NUM_STAGIAIRE = ?";
	        PreparedStatement st = cnx.prepareStatement(req);
	        st.setString(1, code);
	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {
	            String nom_stagiaire = rs.getString("NOM_STAGIAIRE");
	            String prenom_stagiaire = rs.getString("PRENOM_STAGIAIRE");
	            char sexe_stagiaire = rs.getString("SEXE_STAGIAIRE").charAt(0);
	            Date dnaiss_stagiaire = rs.getDate("DNAISS_STAGIAIRE");
	            String diplo_stagiaire = rs.getString("DIPLO_STAGIAIRE");
        		System.out.println("GET STAGIAIRE DAO------------------>");
	            return new Stagiaire(code, nom_stagiaire, prenom_stagiaire, sexe_stagiaire, dnaiss_stagiaire, diplo_stagiaire);
	        }
	        return null;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	public List<Stagiaire> selectAll() {
	    try {
	        String req = "SELECT * FROM STAGIAIRE";
	        Statement st = cnx.createStatement();
	        ResultSet rs = st.executeQuery(req);
	        List<Stagiaire> StagiaireList = new ArrayList<Stagiaire>();
	        while (rs.next()) {
	            String num_stagiaire = rs.getString("NUM_STAGIAIRE");
	            String nom_stagiaire = rs.getString("NOM_STAGIAIRE");
	            String prenom_stagiaire = rs.getString("PRENOM_STAGIAIRE");
	            char sexe_stagiaire = rs.getString("SEXE_STAGIAIRE").charAt(0);
	            Date dnaiss_stagiaire = rs.getDate("DNAISS_STAGIAIRE");
	            String diplo_stagiaire = rs.getString("DIPLO_STAGIAIRE");
	            Stagiaire stagiaire = new Stagiaire(num_stagiaire, nom_stagiaire, prenom_stagiaire, sexe_stagiaire, dnaiss_stagiaire, diplo_stagiaire);
	            StagiaireList.add(stagiaire);
	        }
    		System.out.println("GET_All STAGIAIRE DAO------------------>");
	        return StagiaireList;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	
	public int modifier(String[] values, String condition) {
	    try {
	        String req = "UPDATE STAGIAIRE SET "
	                            + "NOM_STAGIAIRE = '" + values[0] + "', "
	                            + "PRENOM_STAGIAIRE = '" + values[1] + "', "
	                            + "SEXE_STAGIAIRE = '" + values[2] + "', "
	                            + "DNAISS_STAGIAIRE = TO_DATE('" + values[3] + "', 'YYYY-MM-DD'), "
	                            + "DIPLO_STAGIAIRE = '" + values[4] + "' "
	                            + "WHERE NUM_STAGIAIRE = '" + condition + "'";
	        Statement s = cnx.createStatement();
    		System.out.println("UPDATE STAGIAIRE DAO------------------>");
	        return s.executeUpdate(req);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	public int supprimer(String code) {
	    try {
	        String req = "DELETE FROM STAGIAIRE WHERE NUM_STAGIAIRE = '" + code + "'";
	        Statement s = cnx.createStatement();
    		System.out.println("DELETE STAGIAIRE DAO------------------>");
	        return s.executeUpdate(req);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

}
