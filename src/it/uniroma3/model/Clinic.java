package it.uniroma3.model;

import java.util.Map;

public class Clinic {
	
	private Map<String, Doctor> doctors;
	private Map<String, Patient> patients;
	private Map<String, Typology> taypologies;
	
	public Clinic () {}
	
	//METODS GETTER & SETTER
	
	public Map<String, Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Map<String, Doctor> doctors) {
		this.doctors = doctors;
	}

	public Map<String, Patient> getPatients() {
		return patients;
	}

	public void setPatients(Map<String, Patient> patients) {
		this.patients = patients;
	}

	public Map<String, Typology> getTaypologies() {
		return taypologies;
	}

	public void setTaypologies(Map<String, Typology> taypologies) {
		this.taypologies = taypologies;
	}
}
