package friki.tienda.com.tienda.beans;

import org.apache.struts.action.ActionForm;

import friki.tienda.com.tienda.accesDAO.ClienteDAO;
import friki.tienda.com.tienda.beans.ClienteBean;
import friki.tienda.com.tienda.utilities.UtilitiesTienda;
import friki.tienda.com.Persistencia.Usuarioscliente;
import friki.tienda.com.daogenerico.IGenericDAO;
import friki.tienda.com.global.services.Md5Encryption;

import java.util.List;

public class LoginClienteBean extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String contrasenya;
	
	private static Md5Encryption pwdEnc = null;
	
	public LoginClienteBean(String email, String contrasenya) {		
		this.email = email;
		this.contrasenya = contrasenya;		
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

	public Usuarioscliente exist(){
		ClienteDAO<Integer, Usuarioscliente> dao =  new ClienteDAO<Integer, Usuarioscliente>();
		List<Usuarioscliente> lista;
		lista = dao.findByLogin(Usuarioscliente.class, email, contrasenya);
		
		try {
			contrasenya = pwdEnc.encrypt(contrasenya);	
		} catch (Exception e) {
			e.printStackTrace();
			// si se produce error retornamos nulo
			return null;
		} 
		if(lista != null && lista.size() > 0){
			Usuarioscliente usuario = lista.get(0);
			//ClienteBean cliente = new ClienteBean(usuario);
			//cliente.setId_usuario(usuario.getIdUsuario());
			return usuario;
		} else {
			return null;
		}
		
	}
}
