package com.jee.business;

import java.util.List;

import com.jee.beans.Stagiaire;

public interface StagiaireManager {
	
	public int add(Stagiaire c);
	public Stagiaire get(String code);
	public List<Stagiaire> getAll();
	public int update(String[] values, String condition);
	public int remove(String code);
}
