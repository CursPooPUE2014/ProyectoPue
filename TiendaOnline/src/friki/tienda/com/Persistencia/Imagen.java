package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;


/**
 * The persistent class for the imagen database table.
 * 
 */
@Entity
@NamedQuery(name="Imagen.findAll", query="SELECT i FROM Imagen i")
public class Imagen implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_imagen")
	private int idImagen;

	private String descripcion;

	private byte novedad;

	@Column(name="url_imagen")
	private String urlImagen;

	//bi-directional many-to-one association to Articulo
	@ManyToOne
	@JoinColumn(name="id_articulo")
	private Articulo articulo;

	public Imagen() {
	}

	public int getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getNovedad() {
		return this.novedad;
	}

	public void setNovedad(byte novedad) {
		this.novedad = novedad;
	}

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	@Override
	public Integer getKey() {
		return this.idImagen;
	}

}