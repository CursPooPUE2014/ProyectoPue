package friki.tienda.com.tienda.beans;

import java.util.List;

import org.apache.struts.action.ActionForm;

import friki.tienda.com.Persistencia.UsuarioCliente;
import friki.tienda.com.tienda.accesDAO.ClienteDAO;
import friki.tienda.com.tienda.utilities.UtilitiesTienda;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.global.services.Md5Encryption;

public class ClienteBean extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private int	id_usuario;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nif; 
	private String contrasenya;
	private String dir_postal;
	private String email;
	private String telefono;
	private Boolean isValid;
	
	private static Md5Encryption pwdEnc = new Md5Encryption();
	
	public ClienteBean(){}
	public ClienteBean(String nombre, String contrasenya,
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
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {	
		try {
			contrasenya = pwdEnc.encrypt(contrasenya);
			this.contrasenya = contrasenya;	
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
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
	
	public UsuarioCliente saveCliente(UsuarioCliente cliente) {
		// pasamos el cliente a Usuarioscliente para poder guardar
		//UsuarioCliente usuario = cliente.beanToUser();
		GenericDAO<Integer, UsuarioCliente> gdao =  new GenericDAO<Integer, UsuarioCliente>();
		UsuarioCliente savedUser = gdao.save(cliente);
		
		return savedUser;
	}

}
