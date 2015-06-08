package friki.tienda.com.tienda.controladores.carrito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jackson.map.ObjectMapper;


import java.io.IOException;
import java.io.PrintWriter;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class DetalleArticulo extends Action {

	// detalle del producto y sus caracteristicas. No el detalle del carrito!!!
	// sólo del articulo

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		int idArticulo = Integer.parseInt(request.getParameter("id"));

		response.setContentType("application/json");

		Articulo articulo = new Articulo();
		articulo.setIdArticulo(idArticulo);

		IGenericDAO<Integer, Articulo> articuloDAO = new GenericDAO<Integer, Articulo>();

		articulo = articuloDAO.findByKey(articulo, Integer.class);

		try {

			PrintWriter out = response.getWriter();

			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(out, articulo);

			
			
		} catch(IOException e) {

			e.printStackTrace();
		}
		
		
		return null;
	}

}