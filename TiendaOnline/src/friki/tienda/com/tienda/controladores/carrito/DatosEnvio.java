package friki.tienda.com.tienda.controladores.carrito;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.Persistencia.Pedido;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;
import friki.tienda.com.tienda.beans.DatosEnvioBean;

public class DatosEnvio extends Action {

	public ActionForward execute(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// Establecemos tipo de respuesta json.
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		// Creamos objeto json que enviaremos en la response.
		JSONObject json = new JSONObject();
		
		// Recuperamos los parámetros de la request y creamos el objeto.
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String direccion = request.getParameter("direccion");
		String pais = request.getParameter("pais");
		String poblacion = request.getParameter("poblacion");
		String cp = request.getParameter("cp");
		String telefono = request.getParameter("telefono");
		
		DatosEnvioBean datosEnvio = new DatosEnvioBean(nombre, apellidos, 
				direccion, pais, poblacion, cp, telefono);		
	
		// Vemos si se han introducido datos correctos en el form.
		String err = datosEnvio.preValidar(nombre, apellidos, direccion, pais, poblacion, cp, telefono);
		
		json.append("errores", err);
				
		if (err == ""){
		    
			// Grabamos los datos de envío en el pedido.
			IGenericDAO<Integer, Pedido> pedidoDAO = new GenericDAO<Integer,Pedido>();
			
			Pedido sessionPedido = (Pedido) request.getSession().getAttribute("pedido");
			int idPedido = sessionPedido.getIdPedido();
			
			Pedido pedido2 = new Pedido();
			pedido2.setIdPedido(idPedido);
			Pedido pedido = pedidoDAO.findByKey(pedido2, Integer.class);
			
		/*  Actualización de los campos de envío 
		 *  pendientes de incluir en la tabla Pedido.	
			
			pedido.setNombre(nombre);
			pedido.setApellidos(apellidos);
			pedido.setDireccion(direccion);
			pedido.setPais(pais);
			pedido.setPoblacion(poblacion);
			pedido.setCp(cp);
			pedido.setTelefono(telefono);
		*/			
			pedidoDAO.update(pedido);				
			
			// Redirección a pago a fin compra.
			json.append("page_redirect", "pago.jsp");
			
		}else{

			// Redirección a pago a fin datos envío.			
			json.append("page_redirect", "datosEnvio.jsp");
		}

		out.println(json.toString());
		out.close();		
		return null;
	}
}
