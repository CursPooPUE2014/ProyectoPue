package friki.tienda.com.tienda.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts.action.ActionForm;

public class PagoBean extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private String numTarjeta;
	private String fechaCad;
	private String numSecreto;
	
	public PagoBean(String numTarjeta, String fechaCad, String numSecreto) {
		this.numTarjeta = numTarjeta;
		this.fechaCad = fechaCad;
		this.numSecreto = numSecreto;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getFechaCad() {
		return fechaCad;
	}
	public void setFechaCad(String fechaCad) {
		this.fechaCad = fechaCad;
	}
	public String getNumSecreto() {
		return numSecreto;
	}
	public void setNumSecreto(String numSecreto) {
		this.numSecreto = numSecreto;
	}
	
	public String preValidar(String numTarjeta, String fechaCad, String numSecreto) {
		
		String errores = "";
		
		if (numTarjeta == null || numTarjeta.equals("")) {
			errores += "indique el número de la tarjeta</br>";
		} else if (!isNumeric(numTarjeta) || numTarjeta.length() != 16){
			errores += "el número de la tarjeta es incorrecto</br>";
		}

		if (fechaCad == null || fechaCad.equals("")) {
			errores += "indique la fecha de caducidad</br>";
		} else {
			 if (!isDate(fechaCad)) {
				 errores += "fecha incorrecta</br>";
		     } else if (!fechaSup(fechaCad)) {
		    	 errores += "fecha de caducidad no es superior a la fecha actual</br>";
		     }
		}
				
		if (numSecreto == null || numSecreto.equals("")) {
			errores += "indique el número secreto</br>";
		} else if (!isNumeric(numSecreto) || numSecreto.length() != 4){
			errores += "el número secreto es incorrecto</br>";
		}
		return errores;
	}
	
    public boolean isDate(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            formatoFecha.parse(fecha);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
	
    public boolean fechaSup(String fecha) {
        try {
        	Date fechaActual = new Date();
        	SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        	Date fechaCad = formatoFecha.parse(fecha);
        	if (fechaActual.compareTo(fechaCad) == 1){
        		return false;
        	}
        }catch (Exception e) {
            return false;
        }
		return true;
    }
    
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
    
}
