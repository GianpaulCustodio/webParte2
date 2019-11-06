package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Role;
	
	@NotEmpty(message = "Insert name of role")
	@Column(name = "n_Role", nullable=false, length=50)
	private String n_Role;

	public int getId_Role() {
		return id_Role;
	}

	public void setId_Role(int id_Role) {
		this.id_Role = id_Role;
	}

	public String getN_Role() {
		return n_Role;
	}

	public void setN_Role(String n_Role) {
		this.n_Role = n_Role;
	}

	
}
