package com.jee.business;

import java.util.List;

import com.jee.beans.Inscription;

public interface InscriptionManager {
	
	public int add(Inscription c);
	public List<Inscription> getAll(String cs);
	public int get_last_id();
}
