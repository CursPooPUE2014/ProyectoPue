package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;

import java.util.List;


/**
 * The persistent class for the articulo database table.
 * 
 */
@Entity
@NamedQuery(name="Articulo.findAll", query="SELECT a FROM Articulo a")
public class Articulo implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_articulo")
	private int idArticulo;

	private String descripcion;

	@Column(name="id_categoria")
	private int idCategoria;

	@Column(name="id_proveedor")
	private int idProveedor;

	private int id_tipoProducto;

	private String nombre;

	private byte novedad;

	private double precio;

	private int stock;

	//bi-directional many-to-one association to Imagen
	@OneToMany(mappedBy="articulo")
	private List<Imagen> imagens;

	public Articulo() {
	}

	public int getIdArticulo() {
		return this.idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getId_tipoProducto() {
		return this.id_tipoProducto;
	}

	public void setId_tipoProducto(int id_tipoProducto) {
		this.id_tipoProducto = id_tipoProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getNovedad() {
		return this.novedad;
	}

	public void setNovedad(byte novedad) {
		this.novedad = novedad;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Imagen> getImagens() {
		return this.imagens;
	}

	public void setImagens(List<Imagen> imagens) {
		this.imagens = imagens;
	}

	public Imagen addImagen(Imagen imagen) {
		getImagens().add(imagen);
		imagen.setArticulo(this);

		return imagen;
	}

	public Imagen removeImagen(Imagen imagen) {
		getImagens().remove(imagen);
		imagen.setArticulo(null);

		return imagen;
	}

	@Override
	public Integer getKey() {
		return this.idArticulo;
	}

}