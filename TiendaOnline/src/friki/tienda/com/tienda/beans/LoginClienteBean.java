package friki.tienda.com.tienda.beans;

import org.apache.struts.action.ActionForm;
import friki.tienda.com.tienda.beans.ClienteBean;
import friki.tienda.com.global.services.Md5Encryption;

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
		// comprobamos que usuario y pwd no vengan nulos
		// y que el email tenga formato correcto
		String errores = "";
		
		if (email == null || email.equals("")) {
			errores = errores + "indique el e-mail</br>";
			
		} else {
			if(!isValidEmailAddress()){
				errores = errores + "indique un e-mail válido</br>";
			}
		}

		if (contrasenya == null || contrasenya.equals("")) {
			errores =  errores + "indique la contraseña</br>";
		} else {
			if(!isValidPwd()){
				errores =  errores + "la contraseña debe contener"
						+ " al menos 8 caracteres, y estos deben ser"
						+ "alfanuméricos</br>";
			}
		}
		
		return errores;
	}
	
	private boolean isValidPwd() {
		if(contrasenya.length() < 8 || contrasenya.matches("[a-zA-Z0-9]{8,}")){
			return true;
		} else {
			return false;
		}
	}

	private boolean isValidEmailAddress() {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
	public ClienteBean exist(){
		ClienteBean res = null;
		
		try {
			contrasenya = pwdEnc.encrypt(contrasenya);
		} catch (Exception e) {
			e.printStackTrace();
			// si se produce error retornamos nulo
			return null;
		} 
		// consulto a la BBDD
		// si el user existe retorno el objeto

		return res;	
	}
}
