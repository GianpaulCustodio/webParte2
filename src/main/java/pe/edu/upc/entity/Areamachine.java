package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Areamachine")
public class Areamachine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Areamachine;
	
	@NotEmpty(message = "Inserte el nombre del área de la máquina")
	@Column(name = "n_Areamachine", nullable=false, length=50)
	private String n_Areamachine;

	public int getId_Areamachine() {
		return id_Areamachine;
	}

	public void setId_Areamachine(int id_Areamachine) {
		this.id_Areamachine = id_Areamachine;
	}

	public String getN_Areamachine() {
		return n_Areamachine;
	}

	public void setN_Areamachine(String n_Areamachine) {
		this.n_Areamachine = n_Areamachine;
	}


	
}
