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

import friki.tienda.com.tienda.beans.PagoBean;

public class Pago extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// establecemos tipo de respuesta json
		response.setContentType("application/json");
				
		// recuperamos los parámetros de la request y creamos el objeto
		String numTarjeta = request.getParameter("numTarjeta");
		String fechaCad = request.getParameter("fechaCad");
		String numSecreto = request.getParameter("numSecreto");
		
		PagoBean pago = new PagoBean(numTarjeta, fechaCad, numSecreto);
		
		// creamos objeto json que enviaremos en la response
		JSONObject js = new JSONObject();
		
		// vemos si se han introducido datos correctos en el form
		String err = pago.preValidar(numTarjeta, fechaCad, numSecreto);
		
		js.accumulate("errores",err);
		
		PrintWriter pw = response.getWriter();
		pw.write(err);
		pw.flush();
		pw.close();
		
		StringBuilder builder = new StringBuilder();
		
		if (err == ""){
			
			// marcar en la BBDD el pedido como pagado ...
			
			HttpSession sesion = request.getSession(true);
			sesion.invalidate();
			
			//return mapping.findForward("finPago");
			builder.append("{\"redireccionamiento\":\"finPago.jsp\"}");

		}else{
			
			//return mapping.findForward("pago");
			builder.append("{\"redireccionamiento\":\"pago.jsp\"}");
		}
		
		request.setAttribute("redireccionamiento", builder.toString());	
		return null;

	}
	
}
