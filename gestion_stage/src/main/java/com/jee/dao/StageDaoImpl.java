package com.jee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Stage;

public class StageDaoImpl implements StageDao{
    
    private Connection cnx ;
    
    public StageDaoImpl() {
        cnx = SingletonConnection.getInstance().getCnx();
    }

    public int insert(Stage s) {
        try {
            String req = "INSERT INTO STAGE (CODE_STAGE, TYPE_STAGE, DEBUT_STAGE, FIN_STAGE, NBPLACES_STAGE, NBINSCRITS_STAGE) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, s.getCode_stage());
            st.setString(2, s.getType_stage());
            st.setDate(3, new Date(s.getDebut_stage().getTime()));
            st.setDate(4, new Date(s.getFin_stage().getTime()));
            st.setInt(5, s.getNbplace_stage());
            st.setInt(6, s.getNbinscrit_stage());
    		System.out.println("INSERT STAGE DAO------------------>");
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Stage select(String code) {
        try {
            String req = "SELECT * FROM STAGE WHERE CODE_STAGE = ?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String type_stage = rs.getString("TYPE_STAGE");
                Date debut_stage = rs.getDate("DEBUT_STAGE");
                Date fin_stage = rs.getDate("FIN_STAGE");
                int nbplace_stage = rs.getInt("NBPLACES_STAGE");
                int nbinscrit_stage = rs.getInt("NBINSCRITS_STAGE");
        		System.out.println("GET STAGE DAO------------------>");
                return new Stage(code, type_stage, debut_stage, fin_stage, nbplace_stage, nbinscrit_stage);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Stage> selectAll(String cd) {
        try {
            String req = "";
            String cm = "";
            if (cd.equals("date")) {
                req = "SELECT * FROM STAGE ORDER BY DEBUT_STAGE";
                cm = "GET_All STAGE DATE DAO------------------>";
            } else if (cd.equals("type")) {
                req = "SELECT * FROM STAGE ORDER BY TYPE_STAGE";
                cm = "GET_All STAGE TYPE DAO------------------>";
            } else {
                req = "SELECT * FROM STAGE";
                cm = "GET_All STAGE DAO------------------>";
            }
            PreparedStatement st = cnx.prepareStatement(req); 
            ResultSet rs = st.executeQuery();
            List<Stage> StageList = new ArrayList<>();
            while (rs.next()) {
                String code_stage = rs.getString("CODE_STAGE");
                String type_stage = rs.getString("TYPE_STAGE");
                Date debut_stage = rs.getDate("DEBUT_STAGE");
                Date fin_stage = rs.getDate("FIN_STAGE");
                int nbplace_stage = rs.getInt("NBPLACES_STAGE");
                int nbinscrit_stage = rs.getInt("NBINSCRITS_STAGE");
                StageList.add(new Stage(code_stage, type_stage, debut_stage, fin_stage, nbplace_stage, nbinscrit_stage));
            }
    		System.out.println(cm);
            return StageList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int modifier(String[] values, String condition) {
        try {
            String req = "UPDATE STAGE SET "
                        + "TYPE_STAGE = ?, "
                        + "DEBUT_STAGE = ?, "
                        + "FIN_STAGE = ?, "
                        + "NBPLACES_STAGE = ?, "
                        + "NBINSCRITS_STAGE = ? "
                        + "WHERE CODE_STAGE = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, values[0]);
            ps.setDate(2, Date.valueOf(values[1]));
            ps.setDate(3, Date.valueOf(values[2]));
            ps.setInt(4, Integer.parseInt(values[3]));
            ps.setInt(5, Integer.parseInt(values[4]));
            ps.setString(6, condition);
    		System.out.println("UPDATE STAGE DAO------------------>");
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int supprimer(String code) {
        try {
            String req = "DELETE FROM STAGE WHERE CODE_STAGE = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, code);
    		System.out.println("DELETE STAGE DAO------------------>");
            return ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}