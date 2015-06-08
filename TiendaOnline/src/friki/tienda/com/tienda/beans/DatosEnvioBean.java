package friki.tienda.com.tienda.beans;

import java.util.regex.Pattern;

import org.apache.struts.action.ActionForm;

public class DatosEnvioBean extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String tipoVia;
	private String direccion;
	private String numero;
	private String planta;
	private String piso;
	private String escalera;
	private String bloque;
	private String ciudad;
	private String provincia;
	private String pais;
	private String codigoPostal;

	public DatosEnvioBean(String tipoVia, String direccion, String numero,
			String planta, String piso, String escalera, String bloque,
			String ciudad, String provincia, String pais, String codigoPostal) {
		this.tipoVia = tipoVia;
		this.direccion = direccion;
		this.numero = numero;
		this.planta = planta;
		this.piso = piso;
		this.escalera = escalera;
		this.bloque = bloque;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getEscalera() {
		return escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String preValidar(String direccion, String numero, String ciudad,
			String provincia, String pais, String codigoPostal) {

		String errores = "";

		if (direccion == null || direccion.equals("")) {
			errores += "indique su dirección</br>";
		}

		if (numero == null || numero.equals("")) {
			errores += "indique el número</br>";
		}

		if (ciudad == null || ciudad.equals("")) {
			errores += "indique la ciudad</br>";
		}

		if (provincia == null || provincia.equals("")) {
			errores += "indique la provincia</br>";
		}

		if (pais == null || pais.equals("")) {
			errores += "indique el país</br>";
		}

		if (codigoPostal == null || codigoPostal.equals("")) {
			errores += "indique su código postal</br>";
		} else {
			if (!Pattern.matches("^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$",
					codigoPostal)) {
				errores += "el código postal no es correcto</br>";
			}
		}

		return errores;
	}

}