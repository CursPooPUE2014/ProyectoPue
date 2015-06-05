package friki.tienda.com.tienda.beans;

import java.util.regex.Pattern;

import org.apache.struts.action.ActionForm;

public class DatosEnvioBean extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private String pais;
	private String poblacion;
	private String cp;
	private String telefono;
	
	public DatosEnvioBean(String nombre, String apellidos, String direccion,
			String pais, String poblacion, String cp, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.pais = pais;
		this.poblacion = poblacion;
		this.cp = cp;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String preValidar(String nombre, String apellidos, String direccion,
			String pais, String poblacion, String cp, String telefono){			
		
		String errores = "";
		
		if (nombre == null || nombre.equals("")) {
			errores += "indique su nombre</br>";
		}
		
		if (apellidos == null || apellidos.equals("")) {
			errores += "indique sus apellidos</br>";
		}

		if (direccion == null || direccion.equals("")) {
			errores += "indique su dirección</br>";
		}
		
		if (pais == null || pais.equals("")) {
			errores += "indique su país</br>";
		}

		if (poblacion == null || poblacion.equals("")) {
			errores += "indique su poblacion</br>";
		}
				
		// nota: expresiones regulares obtenidas de
		// http://web.ontuts.com/snippets/10-expresiones-regulares-imprescindibles-en-desarrollo-web/
		if (cp == null || cp.equals("")) {
			errores += "indique su código postal</br>";
		} else {
			if (!Pattern.matches("^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$", cp)) {
				errores += "el código postal no es correcto</br>";
			}
		}
				
		if (telefono == null || telefono.equals("")) {
			errores += "indique su teléfono</br>";
		} else {
			if (!Pattern.matches("^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$", cp)) {
				errores += "el teléfono no es correcto</br>";
			}
		}
		
		return errores;
	}
	
}