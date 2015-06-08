package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;

/**
 * The primary key class for the lineapedido database table.
 * 
 */
@Embeddable
public class LineaPedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	
	

	@Column(name="id_pedido", insertable=false, updatable=false)
	private int idPedido;

	@Column(name="id_articulo", insertable=false, updatable=false)
	private int idArticulo;

	public LineaPedidoPK() {
	}
	// Constructor con las 2 claves 
	public LineaPedidoPK(int IdArticulo, int IdPedido){
		this.idArticulo=IdArticulo;
		this.idPedido=IdPedido;
	}
	public int getIdPedido() {
		return this.idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdArticulo() {
		return this.idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LineaPedidoPK)) {
			return false;
		}
		LineaPedidoPK castOther = (LineaPedidoPK)other;
		return 
			(this.idPedido == castOther.idPedido)
			&& (this.idArticulo == castOther.idArticulo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPedido;
		hash = hash * prime + this.idArticulo;
		
		return hash;
	}
	
	public LineaPedidoPK getKey(){
		
		return this;
		
	}
}