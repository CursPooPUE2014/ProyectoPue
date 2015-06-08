package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado")
	private int idEstado;

	private String descripcion;

	private String estado;

	public Estado() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public Integer getKey() {
		return idEstado;
	}

}