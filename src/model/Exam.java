package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;

	@Column (nullable = false)
	private String name;
	private String result;

	@Temporal (TemporalType.DATE)
	private Date examDate;
	
	@Column (nullable = false)
	private String doctor;
	private String patient;

	public Exam() {}

	public Exam(String name, String result, Date examDate, String doctor, String patient) {
		this.name = name;
		this.result = result;
		this.examDate = examDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	//METODS GETTER & SETTER

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public Long getCode() {
		return code;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Exam"); 
		sb.append(" {Code=").append(code); 
		sb.append(", NameExam='").append(name);
		sb.append(", Patient='").append(patient);
		sb.append(", Doctor=").append(doctor);
		sb.append(", ExamDate='").append(examDate);
		sb.append(", Result= '").append(result);
		sb.append("}\n");
		return sb.toString();
	}

}
