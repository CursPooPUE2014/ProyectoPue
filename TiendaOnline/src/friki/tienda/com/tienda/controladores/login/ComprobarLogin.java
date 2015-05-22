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
			HttpServletRequest req, HttpServletResponse resp) 
	{
		// Intentamos obtener el nombre del usuario si es que está ya validado
		String sessionUser = (String) req.getSession().getAttribute("nombre");
		
		if (sessionUser == null){
			return mapping.findForward("login");
		}else{
			return mapping.findForward("datosEnvio");
		}
		
	}
}
