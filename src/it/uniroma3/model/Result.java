package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity 
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;
	
	@Column
	private String value;
	
	@OneToOne
	private Exam exam;
	
	public Result() {}
	
	public Result(String value,Exam exam) {
		this.value = value;
		this.exam = exam;
	}

	//METODS GETTER & SETTER	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Long getCode() {
		return code;
	}	
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Result"); 
		sb.append(" {Code=").append(code);
		sb.append(", Exam='").append(exam);
		sb.append(", Value='").append(value);
		sb.append("}\n");
		return sb.toString();
	}
}
