package friki.tienda.com.tienda.controladores.carrito;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.Lineaspedido;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class ModificarCantidad extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int idArticulo = (int) request.getAttribute("idArticulo");
		int cantidad = (int) request.getAttribute("cantidad");

		List<Lineaspedido> lista = (List<Lineaspedido>) request.getSession()
				.getAttribute("Lineaspedido");

		if (lista != null) {

			for (int i = 0; i < lista.size(); i++) {

				if (lista.get(i).getArticulo().getIdArticulo() == idArticulo) {

					// si stock

					Articulo articulo = new Articulo();
					articulo.setIdArticulo(idArticulo);

					IGenericDAO<Integer, Articulo> articuloDAO = new GenericDAO<Integer, Articulo>();

					articulo = articuloDAO.findByKey(articulo, Integer.class);

					if (articulo.getStock() >= cantidad) {

						lista.get(i).setCantidad(cantidad);
						lista.get(i).setPrecio(articulo.getPrecio()*cantidad);

					} else {

						request.setAttribute("json", crearJsonNOK());
						return null;
					}

				}
			}

		} else {

			request.setAttribute("json", crearJsonNOK());
			return null;
		}

		request.setAttribute("json", crearJsonOK());
		
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