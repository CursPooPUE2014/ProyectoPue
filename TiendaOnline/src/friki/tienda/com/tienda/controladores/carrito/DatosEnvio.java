package friki.tienda.com.tienda.controladores.carrito;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.tienda.beans.DatosEnvioBean;

public class DatosEnvio extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// establecemos tipo de respuesta json
		response.setContentType("application/json");
		
		// recuperamos los parámetros de la request y creamos el objeto
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String direccion = request.getParameter("direccion");
		String pais = request.getParameter("pais");
		String poblacion = request.getParameter("poblacion");
		String cp = request.getParameter("cp");
		String telefono = request.getParameter("telefono");
		
		DatosEnvioBean datosEnvio = new DatosEnvioBean(nombre, apellidos, 
				direccion, pais, poblacion, cp, telefono);		
				
		// creamos objeto json que enviaremos en la response
		JSONObject js = new JSONObject();
		
		// vemos si se han introducido datos correctos en el form
		String err = datosEnvio.preValidar(nombre, apellidos, direccion, pais, poblacion, cp, telefono);
				
		js.accumulate("errores",err);
		
		PrintWriter pw = response.getWriter();
		pw.write(err);
		pw.flush();
		pw.close();
		
		StringBuilder builder = new StringBuilder();
				
		if (err == ""){
		//	return mapping.findForward("pago");
			builder.append("{\"redireccionamiento\":\"pago.jsp\"}");
		}else{
		//	return mapping.findForward("datosEnvio");
			builder.append("{\"redireccionamiento\":\"datosEnvio.jsp\"}");
		}
		
		request.setAttribute("redireccionamiento", builder.toString());	
		return null;

	}

}
