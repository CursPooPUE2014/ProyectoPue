package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;


/**
 * The persistent class for the usuariocliente database table.
 * 
 */
@Entity
@NamedQuery(name="UsuarioCliente.findAll", query="SELECT u FROM UsuarioCliente u")
public class UsuarioCliente implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	private String apellido1;

	private String apellido2;

	private String contrasenya;

	@Column(name="dir_postal")
	private String dirPostal;

	private String email;

	private String nif;

	private String nombre;

	private String telefono;

	public UsuarioCliente() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getContrasenya() {
		return this.contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getDirPostal() {
		return this.dirPostal;
	}

	public void setDirPostal(String dirPostal) {
		this.dirPostal = dirPostal;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public Integer getKey() {
		return idUsuario;
	}

}