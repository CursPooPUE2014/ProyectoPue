package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;


/**
 * The persistent class for the tipoproducto database table.
 * 
 */
@Entity
@NamedQuery(name="TipoProducto.findAll", query="SELECT t FROM TipoProducto t")
public class TipoProducto implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_tipoProducto;

	private String descripcion;

	private String nombre;

	public TipoProducto() {
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

	@Override
	public Integer getKey() {
		return this.id_tipoProducto;
	}

}