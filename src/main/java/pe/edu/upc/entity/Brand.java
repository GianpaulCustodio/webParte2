package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Brand")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Brand;
	
	@NotEmpty(message = "Insert name of brand")
	@Column(name = "n_Brand", nullable=false, length=50)
	private String n_Brand;

	public int getId_Brand() {
		return id_Brand;
	}

	public void setId_Brand(int id_Brand) {
		this.id_Brand = id_Brand;
	}

	public String getN_Brand() {
		return n_Brand;
	}

	public void setN_Brand(String n_Brand) {
		this.n_Brand = n_Brand;
	}

	
}
