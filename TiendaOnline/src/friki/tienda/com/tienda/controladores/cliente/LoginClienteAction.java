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

import friki.tienda.com.Persistencia.UsuarioCliente;
import friki.tienda.com.tienda.operaciones.ClienteOperaciones;

public class LoginClienteAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception {
		// establecemos tipo de respuesta json
		response.setContentType("application/json");
		
		// recuperamos los parámetros de la request y creamos el objeto
		String username = request.getParameter("email");
		String pwd = request.getParameter("contrasenya");

		// creamos objeto json que enviaremos en la response
		JSONObject js = new JSONObject();
		
		UsuarioCliente cliente = new UsuarioCliente(username,pwd);
		

		
		// vemos si se han introducido datos correctos en el form
		String err = ClienteOperaciones.preValidarLogin(cliente);
		
		// si hay errores al validar datos añadimos msg al json
		// si no, comprobamos si el usuario existe en la BBDD
		if(err != null){
			js.put("errores",err);
		} else {
			cliente = ClienteOperaciones.existLogin(cliente);
			// si el usuario es nulo añadimos al json msg de error
			// si no cargamos el usuario en la sesion
			if(cliente == null){
				js.put("errores","Usuario o contraseña incorrecto");
			} else {
				js.put("errores","");
				js.put("cliente",cliente);
				// cargo el cliente en la sesion
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("cliente", cliente);
			}
		}
		 
		PrintWriter pw = response.getWriter();
		pw.write(js.toString());
		pw.flush();
		pw.close();

		return null;
	}
	

}