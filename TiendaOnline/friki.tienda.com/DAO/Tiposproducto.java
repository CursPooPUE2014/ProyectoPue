package DAO;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tiposproducto database table.
 * 
 */
@Entity
@NamedQuery(name="Tiposproducto.findAll", query="SELECT t FROM Tiposproducto t")
public class Tiposproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_tipoProducto;

	private String descripcion;

	private String nombre;

	public Tiposproducto() {
	}

	public int getId_tipoProducto() {
		return this.id_tipoProducto;
	}

	public void setId_tipoProducto(int id_tipoProducto) {
		this.id_tipoProducto = id_tipoProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}