package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;


/**
 * The persistent class for the usuarioadministrador database table.
 * 
 */
@Entity
@NamedQuery(name="UsuarioAdministrador.findAll", query="SELECT u FROM UsuarioAdministrador u")
public class UsuarioAdministrador implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	private String contrasenya;

	private String email;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	public UsuarioAdministrador() {
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

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public Integer getKey() {
		return this.idUsuario;
	}

}