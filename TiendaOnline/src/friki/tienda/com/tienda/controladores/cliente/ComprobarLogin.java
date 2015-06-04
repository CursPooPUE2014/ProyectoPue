package friki.tienda.com.tienda.controladores.cliente;

import java.io.PrintWriter;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComprobarLogin extends Action {

	
	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// Intentamos obtener el nombre del usuario si es que está ya validado
		String sessionUser = (String) request.getSession().getAttribute("idUsuario");
				
		StringBuilder builder = new StringBuilder();
		
		if (sessionUser == null){
			// return mapping.findForward("login");
			builder.append("{\"page_redirect\":\"login.jsp\"}");
		}else{
			// return mapping.findForward("datosEnvio");
			builder.append("{\"page_redirect\":\"datosEnvio.jsp\"}");
		}
		
		request.setAttribute("json", builder.toString());	
	/*	PrintWriter pw = response.getWriter();
		pw.write(builder.toString());
		pw.flush();
		pw.close();
	*/
		
		return null;
	}
}
