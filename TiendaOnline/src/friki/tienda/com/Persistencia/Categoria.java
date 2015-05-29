package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.struts.action.ActionForm;

import friki.tienda.com.daogenerico.IPersistent;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria extends ActionForm implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria")
	private int idCategoria;

	private String descripcion;

	private String nombre;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
		return this.idCategoria;
	}

}