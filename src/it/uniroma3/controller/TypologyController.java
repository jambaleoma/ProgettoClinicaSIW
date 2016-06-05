package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import it.uniroma3.facade.TypologyFacade;
import it.uniroma3.model.Typology;

@ManagedBean
public class TypologyController {

	@EJB
	private TypologyFacade tFacade;
	private Long code;
	private String name;
	private String details;
	private Typology typology;
	private String message;
	private List<Typology> typologies;

	public String createTypology() {
		this.typology = tFacade.create(code, name, details);
		return "typologyAdmin";
	}
	
	public String listTypologies() {
		this.setTypologies(tFacade.getAllTypologies());
			return "allTypologyies";
	}
	
	public String getTypologyByCode(Long code) {
		this.typology = tFacade.getTypologyByCode(code);
			return "typology";
	}
	
	//METODS GETTER & SETTER

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public List<Typology> getTypologies() {
		return typologies;
	}

	public void setTypologies(List<Typology> typologies) {
		this.typologies = typologies;
	}

	public Typology getTypology() {
		return typology;
	}

	public void setTypology(Typology typology) {
		this.typology = typology;
	}

	public Long getCode() {
		return code;
	}
}
