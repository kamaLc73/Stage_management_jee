package com.jee.beans;

import java.sql.Date;

public class Stage {
	private String code_stage;
	private String type_stage;
	private Date debut_stage;
	private Date fin_stage;
	private int nbplace_stage;
	private int nbinscrit_stage;
	
	public Stage() {
	}
	
	public Stage(String code_stage, String type_stage, Date debut_stage, Date fin_stage, int nbplace_stage,
			int nbinscrit_stage) {
		this.code_stage = code_stage;
		this.type_stage = type_stage;
		this.debut_stage = debut_stage;
		this.fin_stage = fin_stage;
		this.nbplace_stage = nbplace_stage;
		this.nbinscrit_stage = nbinscrit_stage;
	}


	public String getCode_stage() {
		return code_stage;
	}

	public void setCode_stage(String code_stage) {
		this.code_stage = code_stage;
	}

	public String getType_stage() {
		return type_stage;
	}

	public void setType_stage(String type_stage) {
		this.type_stage = type_stage;
	}

	public Date getDebut_stage() {
		return debut_stage;
	}

	public void setDebut_stage(Date debut_stage) {
		this.debut_stage = debut_stage;
	}

	public Date getFin_stage() {
		return fin_stage;
	}

	public void setFin_stage(Date fin_stage) {
		this.fin_stage = fin_stage;
	}

	public int getNbplace_stage() {
		return nbplace_stage;
	}

	public void setNbplace_stage(int nbplace_stage) {
		this.nbplace_stage = nbplace_stage;
	}

	public int getNbinscrit_stage() {
		return nbinscrit_stage;
	}

	public void setNbinscrit_stage(int nbinscrit_stage) {
		this.nbinscrit_stage = nbinscrit_stage;
	}

	@Override
	public String toString() {
	    return "Stage [code_stage=" + code_stage.trim() + ", type_stage=" + type_stage.trim() + ", debut_stage=" + debut_stage + ", fin_stage=" + fin_stage + ", nbplace_stage=" + nbplace_stage + ", nbinscrit_stage=" + nbinscrit_stage + "]";
	}
}

