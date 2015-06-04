package friki.tienda.com.tienda.controladores.carrito;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.Lineaspedido;
import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;
import tests.persistencia.TestPersistenciaDAO;


public class DetalleArticulo extends Action {

	// detalle del producto y sus caracteristicas. No el detalle del carrito!!!
	// sólo del articulo

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
				
		int idArticulo = (int) request.getAttribute("idArticulo");

		Articulo articulo = new Articulo();
		articulo.setIdArticulo(idArticulo);

		IGenericDAO<Integer, Articulo> articuloDAO = new GenericDAO<Integer,Articulo>();
		
		articulo = articuloDAO.findByKey(articulo, Integer.class);

		String json = crearJson(articulo);
	
		request.setAttribute("json", json);

		return null;
	}

	private String crearJson(Articulo articulo){

		StringBuilder sb = new StringBuilder();
	
		sb.append(("{\"categoria\":\"")).
			append(articulo.getCategoria());
		sb.append(("{\"descripcion\":\"")).
			append(articulo.getDescripcion());
		sb.append(("{\"imagen\":\"")).
			append(articulo.getImagen());
		sb.append(("{\"nombre\":\"")).
			append(articulo.getNombre());
		sb.append(("{\"novedad\":\"")).
			append(articulo.getNovedad());	
		sb.append(("{\"precio\":\"")).
			append(articulo.getPrecio());	
		sb.append(("{\"stock\":\"")).
			append(articulo.getStock()).
			append("}");
				
		return sb.toString();
		
}
}