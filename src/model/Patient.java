package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@OneToMany(mappedBy = "patient")
	private List<Exam>exams;

	public Patient() {
		this.exams = new ArrayList<Exam>();		
	}

	public Patient(String username, String password, String firstName, String lastName, Date dateOfBirth) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	//METODI GETTER & SETTER

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}


	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Paziente"); 
		sb.append("{id=").append(id); 
		sb.append(", username='").append(username);
		sb.append(", password= '").append(password);
		sb.append(", firstName='").append(firstName); 
		sb.append(", lastName=").append(lastName); 
		sb.append(", Date of birth='").append(dateOfBirth); 
		sb.append("}\n");
		return sb.toString();
	}

	
}
