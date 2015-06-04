package friki.tienda.com.backoffice.formbeans;

import java.io.Serializable;

import org.apache.struts.action.ActionForm;

public class AdministradorBean extends ActionForm {
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String email;
	private String contrasenya;
	private String rol;
	
	
	public AdministradorBean() {
	}
	public AdministradorBean(int idUsuario, String email, String contrasenya,
			String rol) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.contrasenya = contrasenya;
		this.rol = rol;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String preValidar(int idUsuario, String email, String contrasenya,
			String rol, String poblacion, String cp, String telefono){			
		
		String errores = "";
		
		if (idUsuario==0) {
			errores += "indique su id</br>";
		}
		
		if (email == null || email.equals("")) {
			errores += "indique sus correo</br>";
		}

		if (contrasenya == null || contrasenya.equals("")) {
			errores += "indique su contrasenya</br>";
		}
		
		if (rol == null || rol.equals("")) {
			errores += "indique su rol</br>";
		}

		
		
		return errores;
	}
	

}
