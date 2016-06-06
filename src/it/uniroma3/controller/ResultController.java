package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import it.uniroma3.facade.ResultFacade;
import it.uniroma3.model.Result;
import it.uniroma3.model.Exam;

@ManagedBean(name="resultController")
public class ResultController {

	@EJB
	private ResultFacade rFacade;
	private Exam exam;
	private String value;
	private Long id;
	private Result result;
	private List<Result> results;

	public String createResult(){
		this.result = rFacade.createResult(value, exam);
		return "result";
	}

	public String listResults() {
		this.setResults(rFacade.getAllResults());
		return "results"; 
	}

	public String findResult(Long id) {
		this.result = rFacade.getResultById(id);
		return "result";
	}

	public ResultFacade getrFacade() {
		return rFacade;
	}

	public void setrFacade(ResultFacade rFacade) {
		this.rFacade = rFacade;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}