package friki.tienda.com.tienda.controladores.cliente;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;


public class LogoutClienteAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception {
		// establecemos tipo de respuesta json
		response.setContentType("application/json");
		
		// eliminamos de la sesión el cliente a desconectar
		HttpSession sesion = request.getSession(true);
		sesion.removeAttribute("cliente");
		sesion.removeAttribute("Lineaspedido");
		//################################
		// pendiente comprobar el resto de variables cargadas
		// y eliminarlas
		
		JSONObject js = new JSONObject();
		js.put("errores","");

		PrintWriter pw = response.getWriter();
		pw.write(js.toString());
		pw.flush();
		pw.close();

		return null;
	}
	

}

