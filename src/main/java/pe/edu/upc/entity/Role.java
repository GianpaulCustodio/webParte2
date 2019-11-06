package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Rol;
	
	
	@NotEmpty(message = "Insert name of brand")
	@Column(name = "n_Rol", nullable=false, length=50)
	private String n_Rol;

	public int getId_Rol() {
		return id_Rol;
	}

	public void setId_Rol(int id_Rol) {
		this.id_Rol = id_Rol;
	}

	public String getN_Rol() {
		return n_Rol;
	}

	public void setN_Rol(String n_Rol) {
		this.n_Rol = n_Rol;
	}

	
}
