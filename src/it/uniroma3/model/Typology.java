package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Typology {

	@Id
	private Long code;

	@Column (nullable = false)
	private String name;
	private String details;

	@OneToMany
	private List<Exam>exams;

	@ManyToMany(mappedBy = "typologies")
	private List<Doctor>doctors;

	public Typology() {
		this.doctors = new ArrayList<Doctor>();
		this.exams = new ArrayList<Exam>();
	}

	public Typology(Long code, String name, String details) {

		this.code = code;
		this.name = name;
		this.details = details;
		this.doctors = new ArrayList<Doctor>();
		this.exams = new ArrayList<Exam>();
		this.doctors = new ArrayList<Doctor>();
	}
	//METODS ADD & REMOVE
	
	public void addExamToTypology(Exam exam) {
		this.exams.add(exam);
	}
	
	public void addDoctorToTypology(Doctor doctor) {
		this.doctors.add(doctor);
	}
	
	//METODS GETTER & SETTER

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Typology"); 
		sb.append("{code=").append(code); 
		sb.append(", Name='").append(name); 
		sb.append(", Details='").append(details);
		sb.append("}\n");
		return sb.toString();
	}
	
	public String toStringExams() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Typology"); 
		sb.append("{code=").append(code); 
		sb.append(", Name='").append(name); 
		sb.append(", Details='").append(details);
		sb.append("}\n");
		sb.append(", Exams='").append(exams);
		sb.append("}\n");
		return sb.toString();
	}
	
	public String toStringDoctors() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Typology"); 
		sb.append("{code=").append(code); 
		sb.append(", Name='").append(name); 
		sb.append(", Details='").append(details);
		sb.append("}\n");
		sb.append(", Doctors='").append(doctors);
		sb.append("}\n");
		return sb.toString();
	}
}