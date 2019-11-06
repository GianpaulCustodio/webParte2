package pe.edu.upc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Machine")
public class Machine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Machine;

	@NotEmpty(message = "Ingrese su codigo del producto*")
	@Column(name = "cMachine", nullable = false, length = 90)
	private String cMachine;

	@NotNull(message = "La fecha es obligatoria")
	@Column(name = "d_Machine")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_Machine;

	@ManyToOne
	@JoinColumn(name = "id_Brand", nullable = false)
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "id_Areamachine", nullable = false)
	private Areamachine areamachine;
	

	public int getId_Sparepart() {
		return id_Machine;
	}

	public void setId_Sparepart(int id_Sparepart) {
		this.id_Machine = id_Sparepart;
	}

	public int getId_Machine() {
		return id_Machine;
	}

	public void setId_Machine(int id_Machine) {
		this.id_Machine = id_Machine;
	}

	
	public String getcMachine() {
		return cMachine;
	}

	public void setcMachine(String cMachine) {
		this.cMachine = cMachine;
	}

	public Date getD_Machine() {
		return d_Machine;
	}

	public void setD_Machine(Date d_Machine) {
		this.d_Machine = d_Machine;
	}

	public Areamachine getAreamachine() {
		return areamachine;
	}

	public void setAreamachine(Areamachine areamachine) {
		this.areamachine = areamachine;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}


}
