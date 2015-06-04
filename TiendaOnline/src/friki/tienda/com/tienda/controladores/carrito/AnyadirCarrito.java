package friki.tienda.com.tienda.controladores.carrito;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import friki.tienda.com.Persistencia.Pedido;
import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.Lineaspedido;
import friki.tienda.com.Persistencia.LineaspedidoPK;
import friki.tienda.com.Persistencia.Pedido;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnyadirCarrito extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int idArticulo = (int) request.getAttribute("idArticulo");
		int cantidad = (int) request.getAttribute("cantidad");

		List<Lineaspedido> lista = (List<Lineaspedido>) request.getSession()
				.getAttribute("Lineaspedido");

		// Si no hay carrito creado
		if (lista != null) {

			lista = new ArrayList<Lineaspedido>();

			Articulo articulo = new Articulo();
			articulo.setIdArticulo(idArticulo);

			IGenericDAO<Integer, Articulo> articuloDAO = new GenericDAO<Integer, Articulo>();

			articulo = articuloDAO.findByKey(articulo, Integer.class);

			if (articulo.getStock() >= cantidad) {

				Lineaspedido lp = new Lineaspedido();
				lp.setArticulo(articulo);
				lp.setCantidad(cantidad);
				lp.setPrecio(articulo.getPrecio() * cantidad);
				lp.setPedido(new Pedido(4)); // El 4 hay que sustituirlo por el
												// ultimo id de pedido de la
												// BBDD + 1
				lp.setId(new LineaspedidoPK(articulo.getIdArticulo(), lp
						.getPedido().getIdPedido()));

				lista.add(lp);

			} else {

				String json = crearJsonNOK();

				request.setAttribute("json", json);

				return null;

			}

			// Si hay carrito creado
		} else {

			for (Lineaspedido lp : lista) {

				if (lp.getArticulo().getIdArticulo() == idArticulo) {

					Articulo articulo = new Articulo();
					articulo.setIdArticulo(idArticulo);

					IGenericDAO<Integer, Articulo> articuloDAO = new GenericDAO<Integer, Articulo>();

					articulo = articuloDAO.findByKey(articulo, Integer.class);

					if (articulo.getStock() >= cantidad) {

						lp.setCantidad(cantidad);
						lp.setPrecio(articulo.getPrecio() * cantidad);
					}

				} else {

					String json = crearJsonNOK();

					request.setAttribute("json", json);

					return null;

				}

			}

		}

		String json = crearJsonOK();

		request.setAttribute("json", json);

		System.out
				.println("Operación realizada. Has añadido el producto al carrito");
		return null;
	}

	private String crearJsonOK() {

		StringBuilder str = new StringBuilder();

		str.append("{\"resultado\":\"").append("true");

		return str.toString();
	}

	private String crearJsonNOK() {

		StringBuilder str = new StringBuilder();

		str.append("{\"resultado\":\"").append("false");

		return str.toString();
	}

}
