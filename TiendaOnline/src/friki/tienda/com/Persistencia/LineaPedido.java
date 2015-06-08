package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;


/**
 * The persistent class for the lineapedido database table.
 * 
 */
@Entity
@NamedQuery(name="LineaPedido.findAll", query="SELECT l FROM LineaPedido l")
public class LineaPedido implements Serializable, IPersistent<LineaPedidoPK> {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LineaPedidoPK id;

	private int cantidad;

	private double precio;

	//bi-directional many-to-one association to Articulo
	@ManyToOne
	@JoinColumn(name="id_articulo")
	private Articulo articulo;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	public LineaPedido() {
	}

	public LineaPedidoPK getId() {
		return this.id;
	}

	public void setId(LineaPedidoPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public LineaPedidoPK getKey() {
		return this.id;
	}

}