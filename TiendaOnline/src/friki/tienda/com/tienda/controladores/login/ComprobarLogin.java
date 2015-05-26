package friki.tienda.com.tienda.controladores.login;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComprobarLogin extends Action {

	
	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{
		// Intentamos obtener el nombre del usuario si es que está ya validado
		String sessionUser = (String) request.getSession().getAttribute("idUsuario");
		
		if (sessionUser == null){
			return mapping.findForward("login");
		}else{
			return mapping.findForward("datosEnvio");
		}
		
	}
}
