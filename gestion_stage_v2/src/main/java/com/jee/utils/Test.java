package com.jee.utils;


import java.sql.Date;
import java.util.List;

import com.jee.beans.Inscription;
import com.jee.business.Facade;
import com.jee.dao.InscriptionDaoImpl;
import com.jee.dao.StageDaoImpl;
import com.jee.dao.StagiaireDaoImpl;

public class Test {
	public static void main(String[] args) {
//		StageDaoImpl s = new StageDaoImpl();
//		
//		Stage stage = new Stage("S0003", "Type3", Date.valueOf("2024-11-15"), Date.valueOf("2024-12-01"), 3, 40);		
//		s.insert(stage);
		

//		Stage stage2=s.select("S0001");
//		System.out.println(stage2.toString());
		
//		List<Stage> f = s.selectAll("type");
//		 for (Stage stage : f) {
//			System.out.println(stage.toString());
//		}
//        String[] values = {"Type2", "2024-06-10", "2024-06-25", "30", "15"};
//        String condition = "S0001"; // Par exemple, modifier la ligne avec le code "S0001"
//        System.out.println(s.modifier(values, condition));
		
		
//    	s.supprimer("S0001");
//    	List<Stage> f = s.selectAll("type");
//		 for (Stage stage : f) {
//			System.out.println(stage.toString());
//		}

//		StagiaireDaoImpl st = new StagiaireDaoImpl();
//		Stagiaire stagiaire = new Stagiaire("S0002", "dehbi","kamal",'M',Date.valueOf("2004-01-14"),"IND");
//		st.insert(stagiaire);
		
//		System.out.println(st.select("S0001").toString());
		
//		List<Stagiaire> lst = st.selectAll();
//		
//		for (Stagiaire stagiaire : lst) {
//			System.out.println(stagiaire.toString());
//		}
		
		
//        String[] values = {"Elbachar", "walid", "M", "2000-05-20", "MAS"};
//        String condition = "S0002"; 
//        st.modifier(values, condition);
        
//		st.supprimer("S0001");
//
//        
//		List<Stagiaire> lst = st.selectAll();
//        for (Stagiaire stagiaire : lst) {
//			System.out.println(stagiaire.toString());
//		}
		
		
		
		StageDaoImpl stageDao = new StageDaoImpl();
        StagiaireDaoImpl stagiaireDao = new StagiaireDaoImpl();
        InscriptionDaoImpl inscriptionDao = new InscriptionDaoImpl();
        
//        Stage stage = new Stage("S0001", "Type1", Date.valueOf("2024-06-01"), Date.valueOf("2024-06-15"), 20, 10);
//        stageDao.insert(stage);

//        Stagiaire stagiaire = new Stagiaire("S0006", "Doe", "John", 'M', Date.valueOf("1990-01-01"), "BAC");
//        stagiaireDao.insert(stagiaire);

//        Inscription inscription = new Inscription(99, stageDao.select("S0002"), stagiaireDao.select("S0002"), Date.valueOf("2024-12-30"), 'C', 'C');
//        inscriptionDao.insert(inscription);

        List<Inscription> inscriptions = inscriptionDao.selectAll("ST002");
        for (Inscription inscription2 : inscriptions) {
			System.out.println(inscription2.toString());
			System.out.println("-----------------");
		}
		
		Facade f = new Facade();
		
//		StagiaireManagerImpl s = f.getSim();
//		System.out.println(s.get("STG08").toString());
		
//		System.out.println(f.getIm().get_last_id());
		
//		StageManagerImpl sm = f.getSm();
//		List<Stage> lsy = sm.getAll("type");
//		System.out.println("");
//		for (Stage i : lsy) {
//			System.out.println(i.toString());
//		}
//		
//		List<Stage> lsd = sm.getAll("date");
//		System.out.println("");
//		for (Stage i : lsd) {
//			System.out.println(i.toString());
//		}
//			
//		System.out.println("");
//		System.out.println("++++++++++++++++++++");
//		System.out.println("");
//		
//		InscriptionManagerImpl im = f.getIm();
//		System.out.println("");
//		List<Inscription> li = im.getAll("ST001");
//		System.out.println("");
//		for (Inscription i : li) {
//			System.out.println(i.toString());
//		} 
//		
//		System.out.println("");
//		System.out.println("++++++++++++++++++++");
//		System.out.println("");
//		
//		StagiaireManagerImpl sim = f.getSim();
//		System.out.println("");
//		List<Stagiaire> lsim = sim.getAll();
//		for (Stagiaire i : lsim) {
//			System.out.println(i.toString());
//		}
		
//		System.out.println("----------------");
//		System.out.println(f.getSm().get("S0001").toString());
	}
}
