package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import friki.tienda.com.daogenerico.IPersistent;

import java.util.Date;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedido")
	private int idPedido;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_cliente")
	private int idCliente;

	private int id_dirEntrega;

	@Column(name="id_estado")
	private int idEstado;

	@Column(name="total_a_pagar")
	private double totalAPagar;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getId_dirEntrega() {
		return this.id_dirEntrega;
	}

	public void setId_dirEntrega(int id_dirEntrega) {
		this.id_dirEntrega = id_dirEntrega;
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public double getTotalAPagar() {
		return this.totalAPagar;
	}

	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	@Override
	public Integer getKey() {
		return this.idPedido;
	}

}