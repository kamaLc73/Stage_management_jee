package com.jee.beans;

import java.sql.Date;

public class Stagiaire {
	private String num_stagiaire;
	private String nom_stagiaire;
	private String prenom_stagiaire;
	private char sexe_stagiaire;
	private Date dnaiss_stagiaire;
	private String diplo_stagiaire;
	
	public Stagiaire() {
	}
	
	public Stagiaire(String num_stagiaire, String nom_stagiaire, String prenom_stagiaire, char sexe_stagiaire,
			Date dnaiss_stagiaire, String diplo_stagiaire) {
		this.num_stagiaire = num_stagiaire;
		this.nom_stagiaire = nom_stagiaire;
		this.prenom_stagiaire = prenom_stagiaire;
		this.sexe_stagiaire = sexe_stagiaire;
		this.dnaiss_stagiaire = dnaiss_stagiaire;
		this.diplo_stagiaire = diplo_stagiaire;
	}
	
	public String getNum_stagiaire() {
		return num_stagiaire;
	}
	public void setNum_stagiaire(String num_stagiaire) {
		this.num_stagiaire = num_stagiaire;
	}
	public String getNom_stagiaire() {
		return nom_stagiaire;
	}
	public void setNom_stagiaire(String nom_stagiaire) {
		this.nom_stagiaire = nom_stagiaire;
	}
	public String getPrenom_stagiaire() {
		return prenom_stagiaire;
	}
	public void setPrenom_stagiaire(String prenom_stagiaire) {
		this.prenom_stagiaire = prenom_stagiaire;
	}
	public char getSexe_stagiaire() {
		return sexe_stagiaire;
	}
	public void setSexe_stagiaire(char sexe_stagiaire) {
		this.sexe_stagiaire = sexe_stagiaire;
	}
	public Date getDnaiss_stagiaire() {
		return dnaiss_stagiaire;
	}
	public void setDnaiss_stagiaire(Date dnaiss_stagiaire) {
		this.dnaiss_stagiaire = dnaiss_stagiaire;
	}
	public String getDiplo_stagiaire() {
		return diplo_stagiaire;
	}
	public void setDiplo_stagiaire(String diplo_stagiaire) {
		this.diplo_stagiaire = diplo_stagiaire;
	}

	@Override
	public String toString() {
	    return "Stagiaire [num_stagiaire=" + num_stagiaire.trim() + ", nom_stagiaire=" + nom_stagiaire.trim() + ", prenom_stagiaire=" + prenom_stagiaire.trim() + ", sexe_stagiaire=" + sexe_stagiaire + ", dnaiss_stagiaire=" + dnaiss_stagiaire + ", diplo_stagiaire=" + diplo_stagiaire.trim() + "]";
	}

}
