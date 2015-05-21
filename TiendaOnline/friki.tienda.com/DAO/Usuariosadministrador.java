package DAO;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuariosadministrador database table.
 * 
 */
@Entity
@NamedQuery(name="Usuariosadministrador.findAll", query="SELECT u FROM Usuariosadministrador u")
public class Usuariosadministrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	private String contrasenya;

	private String email;

	private String rol;

	public Usuariosadministrador() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasenya() {
		return this.contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}