package com.jee.dao;

import java.util.List;

import com.jee.beans.Inscription;

public interface InscriptionDao {
	
	public int insert(Inscription c);
	public List<Inscription> selectAll(String cs);	
	public int get_last_id();
}
