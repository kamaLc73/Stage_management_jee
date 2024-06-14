package com.jee.business;

import java.util.List;

import com.jee.beans.Stagiaire;
import com.jee.dao.*;

public class StagiaireManagerImpl implements StagiaireManager{
	
	private StagiaireDao sid= new StagiaireDaoImpl();

	public int add(Stagiaire c) {
		System.out.println("INSERT STAGIAIRE BUSINESS------------------>");
		return sid.insert(c);
	}

	public Stagiaire get(String code) {
		System.out.println("GET STAGIARE BUSINESS------------------>");
		return sid.select(code);
	}

	public List<Stagiaire> getAll() {
		System.out.println("GET_ALL STAGIAIRE BUSINESS------------------>");
		return sid.selectAll();
	}

	public int update(String[] values, String condition) {
		System.out.println("UPDATE STAGIAIRE BUSINESS------------------>");
		return sid.modifier(values, condition);
	}

	public int remove(String code) {
		System.out.println("DELETE STAGIAIRE BUSINESS------------------>");
		return sid.supprimer(code);
	}

}
