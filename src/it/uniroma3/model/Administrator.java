package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (unique = true)
	private String username;

	@Column (nullable = false)
	private String password;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String eMail;

	public Administrator() {

	}

	public Administrator(String username, String password, String firstName, String lastName, String eMail) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;

	}

	public boolean verificaPassword(String password) {
		return this.password.equals(password);
	}
	
	//METODS GETTER & SETTER
	
	public Long getId() {
		return id;
	}

	public String getUsername(String username) {
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPwd() {
		return password;
	}

	public void setPwd(String pwd) {
		this.password = pwd;
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

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Administrator"); 
		sb.append("{id=").append(id); 
		sb.append(", username='").append(username);
		sb.append(", password='").append(password); 
		sb.append(", firstName='").append(firstName);
		sb.append(", lastName='").append(lastName);
		sb.append(", eMail='").append(eMail);
		sb.append("}\n");
		return sb.toString();
	}


}
