package friki.tienda.com.Persistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.apache.struts.action.ActionForm;

import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IPersistent;
import friki.tienda.com.global.services.Md5Encryption;
import friki.tienda.com.tienda.accesDAO.ClienteDAO;
import friki.tienda.com.tienda.utilities.UtilitiesTienda;


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
	
	private static Md5Encryption pwdEnc = new Md5Encryption();

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
			contrasenya = contrasenya;
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

	// validaciones Registro de Usuario
	public String preValidarRegistro() {
		String errores = "";
		
		if (nombre == null || nombre.equals("")){
			errores = errores + "indique el nombre</br>";
		}
		
		if (email == null || email.equals("")) {
			errores = errores + "indique el e-mail</br>";
			
		} else {
			if(!UtilitiesTienda.isValidEmailAddress(email)){
				errores = errores + "indique un e-mail válido</br>";
			} else {
				if(!existEmail()){
					errores = errores + "El e-mail ya existe en la base de datos</br>";
				}
			}
		}

		if (contrasenya == null || contrasenya.equals("")) {
			errores =  errores + "indique la contraseña</br>";
		} else {
			if(!UtilitiesTienda.isValidPwd(contrasenya)){
				errores =  errores + "la contraseña debe contener"
						+ " al menos 8 caracteres, y estos deben ser"
						+ "alfanuméricos</br>";
			}
		}
/*		
		if (dirPostal == null || dirPostal.equals("")){
			errores = errores + "indique la direccion</br>";
		}
		*/
		// ###########################################
		/*
		if (telefono != null || !telefono.matches("[0-9]{15,}")){
			errores = errores + "indique un teléfono válido</br>";
		}
*/
		return errores;
	}

	public String preValidarLogin() {
		String errores = "";
		
		if (email == null || email.equals("")) {
			errores = errores + "indique el e-mail</br>";
			
		} else {
			if(!UtilitiesTienda.isValidEmailAddress(email)){
				errores = errores + "indique un e-mail válido</br>";
			}
		}

		if (contrasenya == null || contrasenya.equals("")) {
			errores =  errores + "indique la contraseña</br>";
		} else {
			if(!UtilitiesTienda.isValidPwd(contrasenya)){
				errores =  errores + "la contraseña debe contener"
						+ " al menos 8 caracteres, y estos deben ser"
						+ "alfanuméricos</br>";
			}
		}
		
		return errores;
	}
	
	private boolean existEmail(){
		ClienteDAO<Integer, UsuarioCliente> dao =  new ClienteDAO<Integer, UsuarioCliente>();
		List<UsuarioCliente> lista;
		lista = dao.findByEmail(UsuarioCliente.class, email);

		if(lista != null && lista.size() > 0){
			return true;
		} else {
			return false;
		}	
	}
	
	public UsuarioCliente existLogin(){
		ClienteDAO<Integer, UsuarioCliente> dao =  new ClienteDAO<Integer, UsuarioCliente>();
		List<UsuarioCliente> lista = null;
		/*
		 // de momento no se encripta el pwe
			try {
				contrasenya = pwdEnc.encrypt(contrasenya);	
			} catch (Exception e) {
				e.printStackTrace();
				// si se produce error retornamos nulo
				return null;
			}
		 */
		lista = dao.findByLogin(UsuarioCliente.class, email, contrasenya);

		if(lista != null && lista.size() > 0){
			UsuarioCliente usuario = lista.get(0);
			return usuario;
		} else {
			return null;
		}
		
	}

	public UsuarioCliente saveCliente(UsuarioCliente cliente) {
		GenericDAO<Integer, UsuarioCliente> gdao =  new GenericDAO<Integer, UsuarioCliente>();
		UsuarioCliente savedUser = gdao.save(cliente);		
		return savedUser;
	}

}