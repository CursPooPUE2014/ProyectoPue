package friki.tienda.com.tienda.utilities;

public class UtilitiesTienda {

	public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
	public static boolean isValidPwd(String contrasenya) {
		if(contrasenya.length() < 8 || contrasenya.matches("[a-zA-Z0-9]{8,}")){
			return true;
		} else {
			return false;
		}
	}
}
