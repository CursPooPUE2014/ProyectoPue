package friki.tienda.com.tienda.beans;

import javax.servlet.http.HttpServletRequest;



import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginClienteBean extends ActionForm{
	private String email;
	private String contrasenya;
	
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

}
