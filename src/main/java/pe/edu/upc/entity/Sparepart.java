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

@Entity
@Table(name = "Sparepart")
public class Sparepart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Sparepart;

	@NotEmpty(message = "Ingrese su nombre del producto*")
	@Column(name = "nSparepart", nullable = false, length = 90)
	private String nSparepart;

	@DecimalMin("1.00")
	@DecimalMax("5000.00")
	@Column(name = "price", columnDefinition = "Decimal(8,2)", nullable = false)
	private Double p_Sparepart;

	@ManyToOne
	@JoinColumn(name = "id_Brand", nullable = false)
	private Brand brand;

	public int getId_Sparepart() {
		return id_Sparepart;
	}

	public void setId_Sparepart(int id_Sparepart) {
		this.id_Sparepart = id_Sparepart;
	}

	

	public String getnSparepart() {
		return nSparepart;
	}

	public void setnSparepart(String nSparepart) {
		this.nSparepart = nSparepart;
	}
	
	

	public Double getP_Sparepart() {
		return p_Sparepart;
	}

	public void setP_Sparepart(Double p_Sparepart) {
		this.p_Sparepart = p_Sparepart;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}


}
