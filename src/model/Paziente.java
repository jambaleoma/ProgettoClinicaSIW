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
public class Paziente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String username;
	private String pwd;
	private String nome;
	private String cognome;

	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;

	@OneToMany(mappedBy = "paziente")
	private List<Esame>esami;

	public Paziente() {
		this.esami = new ArrayList<Esame>();		
	}

	public Paziente(String username, String pwd, String nome, String cognome, Date dataDiNascita) {
		this.username = username;
		this.pwd = pwd;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}

	//METODI GETTER & SETTER

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Long getId() {
		return id;
	}

	public boolean equals(Object obj) {
		Paziente product = (Paziente)obj;
		return this.getId().equals(product.getId());
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Paziente"); 
		sb.append("{id=").append(id); 
		sb.append(", username='").append(username);
		sb.append(", password= '").append(pwd);
		sb.append(", nome='").append(nome); 
		sb.append(", cognome=").append(cognome); 
		sb.append(", Data di nascita='").append(dataDiNascita); 
		sb.append("}\n");
		return sb.toString();
	}

	
}
