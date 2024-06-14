package com.jee.beans;

import java.sql.Date;

public class Inscription {
	private int id_inscription;
	private Stage stage;
	private Stagiaire stagiaire;
	private Date date_inscrip;
	private char satut_inscrip;
	private char code_position;
	
	public Inscription() {
	}

	public Inscription(int id_inscription, Stage stage, Stagiaire stagiaire, Date date_inscrip, char satut_inscrip, char code_position) {
		this.id_inscription = id_inscription;
		this.stage = stage;
		this.stagiaire = stagiaire;
		this.date_inscrip = date_inscrip;
		this.satut_inscrip = satut_inscrip;
		this.code_position = code_position;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public Date getDate_inscrip() {
		return date_inscrip;
	}

	public void setDate_inscrip(Date date_inscrip) {
		this.date_inscrip = date_inscrip;
	}

	public char getSatut_inscrip() {
		return satut_inscrip;
	}

	public void setSatut_inscrip(char satut_inscrip) {
		this.satut_inscrip = satut_inscrip;
	}

	public char getCode_position() {
		return code_position;
	}

	public void setCode_position(char code_position) {
		this.code_position = code_position;
	}
	
	public int getId_inscription() {
		return id_inscription;
	}

	public void setId_inscription(int id_inscription) {
		this.id_inscription = id_inscription;
	}

	@Override
	public String toString() {
	    return "Inscription [id_inscription=" + id_inscription + ", stage=" + stage + ", stagiaire=" + stagiaire + ", date_inscrip=" + date_inscrip + ", satut_inscrip=" + satut_inscrip + ", code_position=" + code_position + "]";
	}



	
	
	
}