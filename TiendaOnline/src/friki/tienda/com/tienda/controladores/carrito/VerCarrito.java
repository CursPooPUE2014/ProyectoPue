package friki.tienda.com.tienda.controladores.carrito;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import friki.tienda.com.Persistencia.Pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerCarrito extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) 
	{

		Pedido sessionPedido = (Pedido) req.getSession().getAttribute("pedido");
		
		req.setAttribute("lineasPedido", sessionPedido.getLineaspedidos());
		
		return mapping.findForward("verCarrito");
		
	}
		
}