package friki.tienda.com.Persistencia;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarioscliente database table.
 * 
 */
@Entity
@NamedQuery(name="Usuarioscliente.findAll", query="SELECT u FROM Usuarioscliente u")
public class Usuarioscliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	private String contrasenya;

	@Column(name="dir_postal")
	private String dirPostal;

	private String email;

	private String nombre;

	private int telefono;

	public Usuarioscliente() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}