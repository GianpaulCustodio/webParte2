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

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Inspection")
public class Inspection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Inspection;

	@Column(name = "dateIns")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date D_Inspection;

	@ManyToOne
	@JoinColumn(name = "cMachine",nullable=false)
	private Machine cMachine;
	
   // @ManyToOne
   // @JoinColumn(name = "IdUser",nullable = false)
	//private User id_User
	
	@NotEmpty(message = "Debe ingresar descripcion")
	@Column(name = "T_Inspection",nullable = false,length = 50)
	private String T_Inspection;

	public int getId_Inspection() {
		return id_Inspection;
	}

	public void setId_Inspection(int id_Inspection) {
		this.id_Inspection = id_Inspection;
	}

	public Date getD_Inspection() {
		return D_Inspection;
	}

	public void setD_Inspection(Date d_Inspection) {
		D_Inspection = d_Inspection;
	}


	
	public Machine getC_Machine() {
		return cMachine;
	}

	public void setC_Machine(Machine c_Machine) {
		this.cMachine = c_Machine;
	}

	public String getT_Inspection() {
		return T_Inspection;
	}

	public void setT_Inspection(String t_Inspection) {
		T_Inspection = t_Inspection;
	}
}
