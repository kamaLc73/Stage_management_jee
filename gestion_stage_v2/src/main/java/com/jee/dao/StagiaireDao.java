package com.jee.dao;

import java.util.List;

import com.jee.beans.Stagiaire;

public interface StagiaireDao {
	
	public int insert(Stagiaire c);
	public Stagiaire select(String code);
	public List<Stagiaire> selectAll();
	public int modifier(String[] values, String condition);
	public int supprimer(String code);

}
