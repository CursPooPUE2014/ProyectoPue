package friki.tienda.com.tienda.beans;

import org.apache.struts.action.ActionForm;

import friki.tienda.com.tienda.utilities.UtilitiesTienda;

public class ClienteBean extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private int	id_usuario;
	private String nombre;
	private String contrasenya;
	private String dir_postal;
	private String email;
	private String telefono;
	
	public ClienteBean(){}
	public ClienteBean(String nombre, String contrasenya,
			String dir_postal, String email) {
		super();
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.dir_postal = dir_postal;
		this.email = email;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public String getDir_postal() {
		return dir_postal;
	}
	public void setDir_postal(String dir_postal) {
		this.dir_postal = dir_postal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String preValidar() {
		String errores = "";
		
		if (nombre == null || nombre.equals("")){
			errores = errores + "indique el nombre</br>";
		}
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
		
		if (dir_postal == null || dir_postal.equals("")){
			errores = errores + "indique el nombre</br>";
		}
		
		if (telefono != null || !telefono.matches("[0-9]{9,}")){
			errores = errores + "indique un teléfono válido</br>";
		}
		return errores;
	}

}
