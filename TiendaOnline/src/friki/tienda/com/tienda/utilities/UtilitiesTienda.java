package friki.tienda.com.tienda.utilities;

import javax.servlet.http.HttpServletRequest;

public class UtilitiesTienda {

	public static boolean isValidEmailAddress(String email) {
		// valida una dirección de e-mail
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
	public static boolean isValidPwd(String contrasenya) {
		// valida que el pwd contenga al menos 8 caracteres
		// y que estos sean autonuméricos
		if(contrasenya.length() < 8 || contrasenya.matches("[a-zA-Z0-9]{8,}")){
			return true;
		} else {
			return false;
		}
	}
	public static String pagRedirect(HttpServletRequest request){
		// retorna la url desde donde se ha hecho la petición.
		StringBuffer requestURL  = request.getRequestURL();
		if (request.getQueryString() != null) {
		    requestURL.append("?").append(request.getQueryString());
		}
		String completeURL = requestURL.toString();
		return completeURL;
	}
	
}
