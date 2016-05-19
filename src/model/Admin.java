package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private String id;

	@Column (nullable = false)
	private String pwd;

	public Admin() {

	}

	public Admin(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	//METODI GETTER & SETTER

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean equals(Object obj) {
		Admin product = (Admin)obj;
		return this.getId().equals(product.getId());
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Admin"); 
		sb.append("{id=").append(id); 
		sb.append(", password='").append(pwd); 
		sb.append("}\n");
		return sb.toString();
	}


}
