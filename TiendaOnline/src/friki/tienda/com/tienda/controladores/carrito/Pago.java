package friki.tienda.com.tienda.controladores.carrito;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.Persistencia.Pedido;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;
import friki.tienda.com.tienda.beans.PagoBean;

public class Pago extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
				
		// Recuperamos los parámetros de la request y creamos el objeto.
		String numTarjeta = request.getParameter("numTarjeta");
		String fechaCad = request.getParameter("fechaCad");
		String numSecreto = request.getParameter("numSecreto");
		PagoBean pago = new PagoBean(numTarjeta, fechaCad, numSecreto);
		
		// Vemos si se han introducido datos correctos en el form.
		String err = pago.preValidar(numTarjeta, fechaCad, numSecreto);
		
		json.append("errores", err);
		
		if (err == ""){
			
		    // Marcar en la BBDD el pedido como pagado.
			IGenericDAO<Integer, Pedido> pedidoDAO = new GenericDAO<Integer,Pedido>();
			
			Pedido sessionPedido = (Pedido) request.getSession().getAttribute("pedido");
			int idPedido = sessionPedido.getIdPedido();
			
			Pedido pedido2 = new Pedido();
			pedido2.setIdPedido(idPedido);
			Pedido pedido = pedidoDAO.findByKey(pedido2, Integer.class);
			
			pedido.setEstado("pagado");
			pedidoDAO.update(pedido);
			
			// Limpiar la sesión.			
			HttpSession sesion = request.getSession(true);
			sesion.invalidate();
			
			// Redireccionar a fin compra.
			json.append("page_redirect", "finCompra.jsp");

		}else{

			// Redireccionar a pago.
			json.append("page_redirect", "pago.jsp");

		}
	
		out.println(json.toString());
		out.close();		
		return null;
	}	
}
