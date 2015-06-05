package friki.tienda.com.tienda.controladores.carrito;

import java.io.PrintWriter;
import java.util.List;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.Persistencia.Lineaspedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerCarrito extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		
		@SuppressWarnings("unchecked")
		List<Lineaspedido> lineaspedido = 
				(List<Lineaspedido>) request.getSession().getAttribute("Lineaspedido");
		
		json.put("lineaspedido", lineaspedido);
		
		out.println(json.toString());
		out.close();
		return null;
	}
}