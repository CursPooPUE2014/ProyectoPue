package friki.tienda.com.tienda.controladores.carrito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class Pago extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{
		// establecemos tipo de respuesta json
		response.setContentType("application/json");
		
		// recuperamos los parámetros de la request y creamos el objeto
		String cuenta = request.getParameter("cuenta");
		String fecha = request.getParameter("fecha");
		String clave = request.getParameter("clave");
		
		
		return null;
	}

	public String preValidar(String cuenta, String fecha, String clave) {
		String errores = "";
		
		if (cuenta == null || cuenta.equals("")) {
			errores += "indique una cuenta";
		}

		if (fecha == null || fecha.equals("")) {
			errores += "indique una fecha";
		}
				
		if (clave == null || clave.equals("")) {
			errores += "indique una clave";
		}
		return errores;
	}
	
	
}
