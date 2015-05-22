package friki.tienda.com.tienda.beans;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class loginClienteBean extends ActionForm{
	private String email;
	private String contrasenya;
	
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
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (email == null || email.equals("")) {
			errors.add("email", new ActionMessage("error.email"));
			if(!isValidEmailAddress(email)){
				errors.add("email", new ActionMessage("error.email"));
			}
		}

		if (contrasenya == null || contrasenya.equals("")) {
			errors.add("contrasenya", new ActionMessage("error.contrasenya"));
		}
		return errors;
	}
	
	private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }

}
