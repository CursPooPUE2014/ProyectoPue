package friki.tienda.com.tienda.controladores.carrito;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import friki.tienda.com.Persistencia.Lineaspedido;

public class EliminarDelCarrito extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) {

		int idArticulo = (int) request.getAttribute("idArticulo");

		int cantidad = (int) request.getAttribute("cantidad");

		List<Lineaspedido> lista = (List<Lineaspedido>) request.getSession()
				.getAttribute("Lineaspedido");

		for (int i = 0; i < lista.size(); i++) {

			if (lista.get(i).getArticulo().getIdArticulo() == idArticulo) {

				lista.remove(i);

				String json = crearJsonOK();

				request.setAttribute("json", crearJsonOK());

			}

		}

		String json = crearJsonNOK();

		request.setAttribute("json", crearJsonNOK());

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
