package friki.tienda.com.tienda.controladores.carrito;

import java.util.List;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import friki.tienda.com.Persistencia.Lineaspedido;
import friki.tienda.com.Persistencia.Pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerCarrito extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{
		
	//	response.setContentType("application/json");
		response.setContentType("text/plain");
		
	//	Pedido sessionPedido = (Pedido) request.getSession().getAttribute("pedido");
	//	List<Lineaspedido> lineaspedidos = sessionPedido.getLineaspedidos();
		
		List<Lineaspedido> lineasPedido = 
				(List<Lineaspedido>) request.getSession().getAttribute("lineasPedido");
		
		for (Lineaspedido lineaPedido : lineasPedido) {
			StringBuilder builder = 
				new StringBuilder().
					append("{\"articulo\":\"").
						append(lineaPedido.getArticulo()).					
					append("\",\"cantidad\":").
						append(lineaPedido.getCantidad()).
					append("}");
		}
		
		return mapping.findForward("verCarrito");
		
	}
		
}