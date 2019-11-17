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
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Inspection")
public class Inspection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInspection")
	private int idInspection;

	@NotNull(message = "La fecha es obligatoria")
	@Past(message = "La fecha no puede ser futura")
	@Column(name = "d_Inspection")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
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

	public int getIdInspection() {
		return idInspection;
	}

	public void setIdInspection(int idInspection) {
		this.idInspection = idInspection;
	}

	public String gettInspection() {
		return tInspection;
	}

	public void settInspection(String tInspection) {
		this.tInspection = tInspection;
	}
	
	
	
}
