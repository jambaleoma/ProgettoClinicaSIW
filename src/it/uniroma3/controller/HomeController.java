package it.uniroma3.controller;

//Home controller

import java.util.List;

import it.uniroma3.model.Typology;
import it.uniroma3.persistence.TypologyDao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeController {
	
	@EJB (beanName="aDao")
	private TypologyDao typologyDao;
	private List<Typology> typologies;
	
	@PostConstruct
	public void init() {
	  this.typologies = this.typologyDao.findAll();
	}
	
	public String home() {
		this.typologies = this.typologyDao.findAll();
		return "index";
	}

	public List<Typology> getTypologies() {
		return typologies;
	}

	public void setTypologies(List<Typology> typologies) {
		this.typologies = typologies;
	}
}
