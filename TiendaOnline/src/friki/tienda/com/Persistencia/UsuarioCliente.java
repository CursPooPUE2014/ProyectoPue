package friki.tienda.com.Persistencia;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.struts.action.ActionForm;
import friki.tienda.com.daogenerico.IPersistent;
// import friki.tienda.com.global.services.Md5Encryption;


/**
 * The persistent class for the usuariocliente database table.
 * 
 */
@Entity
@NamedQuery(name="UsuarioCliente.findAll", query="SELECT u FROM UsuarioCliente u")
public class UsuarioCliente extends ActionForm implements Serializable, IPersistent<Integer> {
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
	
	// Para controlar si hay excepcion al encriptar el pwd
	private Boolean isValid;
	
	// private static Md5Encryption pwdEnc = new Md5Encryption();

	public UsuarioCliente() {
	}
	
	// Constructor para el registro de usuario
	/*
	public UsuarioCliente(String nombre, String contrasenya,
			String email) {
		try {
			contrasenya = pwdEnc.encrypt(contrasenya);
			this.nombre = nombre;
			this.email = email;
			this.contrasenya = contrasenya;	
			isValid = true;
		} catch (Exception e) {
			isValid = false;
			e.printStackTrace();
		}		
	}
*/
	// Constructor para el registro de usuario
	// sin encriptar el pwd
	public UsuarioCliente(String nombre, String contrasenya,
			String email) {
			this.contrasenya = contrasenya;
			this.nombre = nombre;
			this.email = email;
			this.contrasenya = contrasenya;	
			isValid = true;		
	}
	
	// Constructor para el login
	public UsuarioCliente(String email, String contrasenya) {	

		this.email = email;
		this.contrasenya = contrasenya;	
		this.isValid = true;
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
	
	public Boolean getIsValid() {
		return isValid;
	}

	@Override
	public Integer getKey() {
		return idUsuario;
	}

}