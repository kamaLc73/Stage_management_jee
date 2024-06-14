package com.jee.business;

import java.util.List;

import com.jee.beans.Inscription;
import com.jee.dao.*;

public class InscriptionManagerImpl implements InscriptionManager{
	
	private InscriptionDao id = new InscriptionDaoImpl();

	public int add(Inscription c) {
		System.out.println("INSERT INSCRIPTION BUSINESS------------------>");
		return id.insert(c);
	}

	public List<Inscription> getAll(String cs) {
		System.out.println("GET_ALL INSCRIPTION BUSINESS------------------>");
		return id.selectAll(cs);
	}

	@Override
	public int get_last_id() {
		return id.get_last_id();
	}

}
