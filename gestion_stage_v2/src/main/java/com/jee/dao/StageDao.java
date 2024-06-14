package com.jee.dao;

import java.util.List;

import com.jee.beans.Stage;

public interface StageDao {
	
	public int insert(Stage c);
	public Stage select(String code);
	public List<Stage> selectAll(String cd);
	public int modifier(String[] values, String condition);
	public int supprimer(String code);
	
}
