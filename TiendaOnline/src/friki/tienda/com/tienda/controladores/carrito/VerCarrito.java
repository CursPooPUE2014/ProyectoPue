package friki.tienda.com.tienda.controladores.carrito;

import java.util.List;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import friki.tienda.com.Persistencia.Lineaspedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerCarrito extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{
		
		response.setContentType("application/json");
	//	response.setContentType("text/plain");
		
	//	Pedido sessionPedido = (Pedido) request.getSession().getAttribute("pedido");
	//	List<Lineaspedido> lineaspedidos = sessionPedido.getLineaspedidos();
		
		@SuppressWarnings("unchecked")
		List<Lineaspedido> lineasPedido = 
				(List<Lineaspedido>) request.getSession().getAttribute("lineasPedido");
		
		
		StringBuilder builder = new StringBuilder();
		for (Lineaspedido lineaPedido : lineasPedido) {
			builder.append("{\"idPedido\":\"").
						append(lineaPedido.getPedido().getIdPedido()).
					append("\"idArticulo\":\"").
						append(lineaPedido.getArticulo().getIdArticulo()).
					append("\"nombreArticulo\":\"").
						append(lineaPedido.getArticulo().getNombre()).	
					append("\"precioArticulo\":\"").
						append(lineaPedido.getArticulo().getPrecio()).	
					append("\",\"cantidad\":\"").
						append(lineaPedido.getCantidad()).
					append("\",\"precio\":\"").
						append(lineaPedido.getPrecio()).
					append("\"}");
		}
		builder.append(",{\"redireccionamiento\":\"verCarrito.jsp\"}");
				
		request.setAttribute("lineasPedidosJSON", builder.toString());		
		
	//  return mapping.findForward("verCarrito");		
		return null;
	
	}
		
}