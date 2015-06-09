package friki.tienda.com.tienda.beans;

import org.apache.struts.action.ActionForm;

import friki.tienda.com.tienda.accesDAO.ClienteDAO;
import friki.tienda.com.tienda.utilities.UtilitiesTienda;
import friki.tienda.com.Persistencia.UsuarioCliente;
import friki.tienda.com.global.services.Md5Encryption;

import java.util.List;

public class LoginClienteBean extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String contrasenya;
	private Boolean isValid;
	
	private static Md5Encryption pwdEnc = new Md5Encryption();
	
/*	
	public LoginClienteBean(String email, String contrasenya) {	
			try {
				contrasenya = pwdEnc.encrypt(contrasenya);
				this.email = email;
				this.contrasenya = contrasenya;	
				this.isValid = true;
			} catch (Exception e) {
				this.isValid = false;
				e.printStackTrace();
			}
	}
*/	
	// constructor sin encriptar
	public LoginClienteBean(String email, String contrasenya) {	

			this.email = email;
			this.contrasenya = contrasenya;	
			this.isValid = true;
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
		try {
			contrasenya = pwdEnc.encrypt(contrasenya);
			this.contrasenya = contrasenya;	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String preValidar() {
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

	public UsuarioCliente existEmail(){
		ClienteDAO<Integer, UsuarioCliente> dao =  new ClienteDAO<Integer, UsuarioCliente>();
		List<UsuarioCliente> lista;
		lista = dao.findByLogin(UsuarioCliente.class, email, contrasenya);

		try {
			contrasenya = pwdEnc.encrypt(contrasenya);	
		} catch (Exception e) {
			e.printStackTrace();
			// si se produce error retornamos nulo
			return null;
		} 
		if(lista != null && lista.size() > 0){
			UsuarioCliente usuario = lista.get(0);
			return usuario;
		} else {
			return null;
		}
		
	}
}
