package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String firstName;
	
	@Column (unique = true)
	private String lastName;

	@OneToMany(mappedBy = "doctor")
	private List<Exam>exams;

	@ManyToMany (fetch=FetchType.EAGER)
	private List<Typology>typologies;

	public Doctor() {
		this.typologies = new ArrayList<Typology>();
	}

	public Doctor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.exams = new ArrayList<Exam>();
	}

	//METODS ADD & REMOVE

	public void addExamToDoctor(Exam exam) {
		this.exams.add(exam);
	}

	public void addDoctorToTypology(Typology typology) {
		this.typologies.add(typology);
	}

	//METODS GETTER & SETTER

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Long getId() {
		return id;
	}

	public List<Typology> getTypologies() {
		return typologies;
	}

	public void setTypologies(List<Typology> typologies) {
		this.typologies = typologies;
	}

	public String toStringTypologies() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Doctor"); 
		sb.append("{id=").append(id); 
		sb.append(", firstName='").append(firstName); 
		sb.append(", lastName='").append(lastName);
		sb.append("}\n");
		sb.append("Typologies: \n").append(typologies);
		sb.append("}\n");
		return sb.toString();
	}

	public String toStringExams() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Doctor"); 
		sb.append("{id=").append(id); 
		sb.append(", firstName='").append(firstName); 
		sb.append(", lastName='").append(lastName);
		sb.append("}\n");
		sb.append(", Exams='").append(exams);
		sb.append("}\n");
		return sb.toString();
	}

}
