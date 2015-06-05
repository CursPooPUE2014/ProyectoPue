package friki.tienda.com.tienda.controladores.cliente;

import java.io.PrintWriter;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComprobarLogin extends Action {

	
	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
				
		// Intentamos obtener el nombre del usuario si es que está ya validado.
		String sessionUser = (String) request.getSession().getAttribute("idUsuario");
		
		if (sessionUser == null || sessionUser == ""){
			json.append("page_redirect", "login.jsp");
		}else{
			json.append("page_redirect", "datosEnvio.jsp");
		}
		
		out.println(json.toString());
		out.close();	
		return null;
	}
}
