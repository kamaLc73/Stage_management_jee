package com.jee.business;

import java.util.List;

import com.jee.beans.Stage;

public interface StageManager {

	public int add(Stage c);
	public Stage get(String code);
	public List<Stage> getAll(String cd);
	public int update(String[] values, String condition);
	public int remove(String code);
}
