package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;


/**
 * The persistent class for the direccionentrega database table.
 * 
 */
@Entity
@NamedQuery(name="DireccionEntrega.findAll", query="SELECT d FROM DireccionEntrega d")
public class DireccionEntrega implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_dirEntrega;

	private String bloque;

	private String ciudad;

	private String codigoPostal;

	private String direccion;

	private String escalera;

	private String numero;

	private String pais;

	private int piso;

	private int planta;

	private String provincia;

	private String tipoVia;

	public DireccionEntrega() {
	}

	public int getId_dirEntrega() {
		return this.id_dirEntrega;
	}

	public void setId_dirEntrega(int id_dirEntrega) {
		this.id_dirEntrega = id_dirEntrega;
	}

	public String getBloque() {
		return this.bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEscalera() {
		return this.escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPiso() {
		return this.piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getPlanta() {
		return this.planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTipoVia() {
		return this.tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	@Override
	public Integer getKey() {
		return this.id_dirEntrega;
	}

}