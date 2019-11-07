package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_User;
	
	
	
	@NotEmpty(message = "Ingrese su nombre")
	@Column(name = "nFirstName", nullable = false, length = 70)
	private String nFirstName;

	@NotEmpty(message = "Ingrese su apellido")
	@Column(name = "nlastName", nullable = false, length = 70)
	private String nlastName;

	@Size(min = 8, max = 8)
	@NotEmpty(message = "Ingrese DNI")
	@Column(name = "d_user", nullable = false, length = 8)
	private String d_user;
	

	@Column(length = 30, unique = true)
	private String nUser;
	
	@NotNull(message = "La fecha es obligatoria")
	@Column(name = "dateOf")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOf;
	
	@ManyToOne
	@JoinColumn(name = "id_Role", nullable = false)
	private Role role;

	@Column(length = 200)
	private String security_key;


	private Boolean f_Estado;


	public int getId_User() {
		return id_User;
	}


	public void setId_User(int id_User) {
		this.id_User = id_User;
	}


	public String getnFirstName() {
		return nFirstName;
	}


	public void setnFirstName(String nFirstName) {
		this.nFirstName = nFirstName;
	}


	public String getNlastName() {
		return nlastName;
	}


	public void setNlastName(String nlastName) {
		this.nlastName = nlastName;
	}


	public String getD_user() {
		return d_user;
	}


	public void setD_user(String d_user) {
		this.d_user = d_user;
	}


	public String getnUser() {
		return nUser;
	}


	public void setnUser(String nUser) {
		this.nUser = nUser;
	}


	public Date getDateOf() {
		return dateOf;
	}


	public void setDateOf(Date dateOf) {
		this.dateOf = dateOf;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getSecurity_key() {
		return security_key;
	}


	public void setSecurity_key(String security_key) {
		this.security_key = security_key;
	}


	public Boolean getF_Estado() {
		return f_Estado;
	}


	public void setF_Estado(Boolean f_Estado) {
		this.f_Estado = f_Estado;
	}

	

	

	
	
	
	
}
