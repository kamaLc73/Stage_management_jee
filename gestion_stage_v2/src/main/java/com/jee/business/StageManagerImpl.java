package com.jee.business;

import java.util.List;

import com.jee.beans.Stage;
import com.jee.dao.*;

public class StageManagerImpl implements StageManager{
	
	private StageDao sd = new StageDaoImpl();

	public int add(Stage c) {
		System.out.println("INSERT STAGE BUSINESS------------------>");
		return sd.insert(c);
	}

	public Stage get(String code) {
		System.out.println("GET STAGE BUSINESS------------------>");
		return sd.select(code);
	}

	public List<Stage> getAll(String cd) {
		System.out.println("GET_ALL STAGE BUSINESS------------------>");
		return sd.selectAll(cd);
	}

	public int update(String[] values, String condition) {
		System.out.println("UPDATE STAGE BUSINESS------------------>");
		return sd.modifier(values, condition);
	}

	public int remove(String code) {
		System.out.println("DELETE STAGE BUSINESS------------------>");
		return sd.supprimer(code);
	}

}
