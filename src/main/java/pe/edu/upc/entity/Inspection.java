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
	@Column(name = "id_inspection")
	private int id_inspection;

	@Column(name = "d_Inspection")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_Inspection;

	@ManyToOne
	@JoinColumn(name = "id_Machine",nullable=false)
	private Machine machine;
	
   @ManyToOne
    @JoinColumn(name = "id_User",nullable = false)
   private Users user;
	
	@NotEmpty(message = "Debe ingresar descripcion")
	@Column(name = "tInspection",nullable = false,length = 50)
	private String tInspection;

	public int getId_Inspection() {
		return id_inspection;
	}

	public void setId_Inspection(int id_Inspection) {
		this.id_inspection = id_Inspection;
	}

	public Date getD_Inspection() {
		return d_Inspection;
	}

	public void setD_Inspection(Date d_Inspection) {
		this.d_Inspection = d_Inspection;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getT_Inspection() {
		return tInspection;
	}

	public void setT_Inspection(String t_Inspection) {
		this.tInspection = t_Inspection;
	}



	
}
