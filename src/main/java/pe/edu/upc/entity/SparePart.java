 	package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SparePart")
public class SparePart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_SparePart;

	@NotEmpty(message = "Debe ingresar nombre")
	@Column(name = "n_SparePart", nullable = false, length = 25)
	private String n_SparePart;

	@ManyToOne
	@JoinColumn(name = "brand", nullable = false)
	private Brand brand;

	@DecimalMin("0.00")
	@DecimalMax("5000.00")
	@NotNull
	@Column(name = "p_SparePart", nullable = false, length = 50)
	private double p_SparePart;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getId_SparePart() {
		return id_SparePart;
	}

	public void setId_SparePart(int id_SparePart) {
		this.id_SparePart = id_SparePart;
	}

	public String getN_SparePart() {
		return n_SparePart;
	}

	public void setN_SparePart(String n_SparePart) {
		this.n_SparePart = n_SparePart;
	}

	public double getP_SparePart() {
		return p_SparePart;
	}

	public void setP_SparePart(double p_SparePart) {
		this.p_SparePart = p_SparePart;
	}

	

}
