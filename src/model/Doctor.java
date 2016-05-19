package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String lastName;

	@OneToMany(mappedBy = "doctor")
	private List<Exam>exams;

	@ManyToMany(mappedBy = "doctor")
	private List<Typology>typologies;
	
	public Doctor() {
		this.exams = new ArrayList<Exam>();
		this.typologies = new ArrayList<Typology>();
	}

	public Doctor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.exams = new ArrayList<Exam>();
		this.typologies = new ArrayList<Typology>();
	}

	//METODS ADD & REMOVE

	public void addDoctorToExam(Exam exam) {
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
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Doctor"); 
		sb.append("{id=").append(id); 
		sb.append(", firstName='").append(firstName); 
		sb.append(", lastName=").append(lastName); 
		sb.append("}\n");
		return sb.toString();
	}
	
}