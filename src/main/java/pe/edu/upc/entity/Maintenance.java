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
@Table(name = "Maintenance")
public class Maintenance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMaintenance;

	@NotEmpty(message = "Ingrese su codigo del mantenimiento")
	@Column(name = "tMaintenance", nullable = false, length = 90)
	private String tMaintenance;

	@NotNull(message = "La fecha es obligatoria")
	@Column(name = "d_Maintenance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_Maintenance;

	@ManyToOne
	@JoinColumn(name = "id_User", nullable = false)
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "idInspection", nullable = false)
	private Inspection inspection;
	
	@ManyToOne
	@JoinColumn(name = "id_Sparepart", nullable = false)
	private Sparepart sparepart;

	public int getIdMaintenance() {
		return idMaintenance;
	}

	public void setIdMaintenance(int idMaintenance) {
		this.idMaintenance = idMaintenance;
	}

	public String gettMaintenance() {
		return tMaintenance;
	}

	public void settMaintenance(String tMaintenance) {
		this.tMaintenance = tMaintenance;
	}

	public Date getD_Maintenance() {
		return d_Maintenance;
	}

	public void setD_Maintenance(Date d_Maintenance) {
		this.d_Maintenance = d_Maintenance;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Inspection getInspection() {
		return inspection;
	}

	public void setInspection(Inspection inspection) {
		this.inspection = inspection;
	}

	public Sparepart getSparepart() {
		return sparepart;
	}

	public void setSparepart(Sparepart sparepart) {
		this.sparepart = sparepart;
	}

	


}
