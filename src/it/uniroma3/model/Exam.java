package it.uniroma3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date bookingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date examDate;

	@ManyToOne
	private Typology typology;
	
	@ManyToOne
    private Patient patient;
	
	@ManyToOne
    private Doctor doctor;
		
	public Exam() {}

	public Exam(Date bookingDate, Date examDate, Typology typology, Patient patient, Doctor doctor) {
		this.bookingDate = bookingDate;
		this.examDate = examDate;
		this.typology = typology;
		this.doctor = doctor;
		this.patient = patient;
		
	}

	//METODS GETTER & SETTER
	
	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
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


	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Typology getTypology() {
		return typology;
	}

	public void setTypology(Typology typology) {
		this.typology = typology;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Exam"); 
		sb.append(" {Code=").append(code);
		sb.append(", Booking Date='").append(bookingDate);
		sb.append(", Exam Date='").append(examDate);
		sb.append(", Doctor='").append(doctor);
		sb.append(", Patient='").append(patient);
		sb.append("}\n");
		return sb.toString();
	}

}
