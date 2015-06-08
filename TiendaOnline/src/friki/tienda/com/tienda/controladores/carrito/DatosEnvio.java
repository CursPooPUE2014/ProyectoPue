package friki.tienda.com.tienda.controladores.carrito;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.Persistencia.DireccionEntrega;
import friki.tienda.com.Persistencia.Pedido;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;
import friki.tienda.com.tienda.beans.DatosEnvioBean;

public class DatosEnvio extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Establecemos tipo de respuesta json.
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		// Creamos objeto json que enviaremos en la response.
		JSONObject json = new JSONObject();

		// Recuperamos los parámetros de la request y creamos el objeto.
		String tipoVia = request.getParameter("tipoVia");
		String direccion = request.getParameter("direccion");
		String numero = request.getParameter("numero");
		String planta = request.getParameter("planta");
		String piso = request.getParameter("piso");
		String escalera = request.getParameter("escalera");
		String bloque = request.getParameter("bloque");
		String ciudad = request.getParameter("ciudad");
		String provincia = request.getParameter("provincia");
		String pais = request.getParameter("pais");
		String codigoPostal = request.getParameter("codigoPostal");

		DatosEnvioBean datosEnvio = new DatosEnvioBean(tipoVia, direccion,
				numero, planta, piso, escalera, bloque, ciudad, provincia,
				pais, codigoPostal);

		// Vemos si se han introducido datos correctos en el form.
		String err = datosEnvio.preValidar(direccion, numero, ciudad,
				provincia, pais, codigoPostal);

		json.append("errores", err);

		if (err == "") {

			// Grabamos los datos de envío en el pedido.
			IGenericDAO<Integer, Pedido> pedidoDAO = new GenericDAO<Integer, Pedido>();

			Pedido sessionPedido = (Pedido) request.getSession().getAttribute(
					"pedido");
			int idPedido = sessionPedido.getIdPedido();

			Pedido pedido2 = new Pedido();
			pedido2.setIdPedido(idPedido);
			Pedido pedido = pedidoDAO.findByKey(pedido2, Integer.class);

		//  Actualización de los campos de envío en la tabla direccionEntrega.
			  
			int idDirEntrega = pedido.getId_dirEntrega();
		
			DireccionEntrega direccionEntrega2 = new DireccionEntrega();
			direccionEntrega2.setId_dirEntrega(idDirEntrega);
			 
			IGenericDAO<Integer, DireccionEntrega> direccionEntregaDAO = 
				 new GenericDAO<Integer, DireccionEntrega>();
			 
			DireccionEntrega direccionEntrega = 
				 direccionEntregaDAO.findByKey(direccionEntrega2, Integer.class);
			 	  
			direccionEntrega.setTipoVia(tipoVia);
			direccionEntrega.setDireccion(direccion);
			direccionEntrega.setNumero(numero);
			direccionEntrega.setPlanta(Integer.parseInt(planta));
			direccionEntrega.setPiso(Integer.parseInt(piso));
			direccionEntrega.setEscalera(escalera);
			direccionEntrega.setBloque(bloque);
			direccionEntrega.setCiudad(ciudad);
			direccionEntrega.setProvincia(provincia);
			direccionEntrega.setPais(pais);
			direccionEntrega.setCodigoPostal(codigoPostal);
			 
			direccionEntregaDAO.update(direccionEntrega);
			 
			// Redirección a pago a fin compra.
			json.append("page_redirect", "pago.jsp");

		} else {

			// Redirección a pago a fin datos envío.
			json.append("page_redirect", "datosEnvio.jsp");
		}

		out.println(json.toString());
		out.close();
		return null;
	}
}
