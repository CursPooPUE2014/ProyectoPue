package friki.tienda.com.tienda.controladores.cliente;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.Persistencia.UsuarioCliente;

public class ComprobarLogin extends Action {

	
	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();		
		
		// Intentamos obtener el usuario cliente si es que está ya validado
		UsuarioCliente cliente = (UsuarioCliente) request.getSession().getAttribute("cliente");
		
		if (cliente == null){
			json.append("page_redirect", "login.jsp");
		}else{
			json.append("page_redirect", "datosEnvio.jsp");
		}
		
		out.println(json.toString());
		out.close();
		return null;
	}
}
