package friki.tienda.com.backoffice.actions.gestionCatalogo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONException;
import org.json.JSONObject;
import friki.tienda.com.Persistencia.Categoria;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class EditarCategoria extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) {

	
		resp.setContentType("application/json");

		PrintWriter out;

		try {
			
			//Obtenemos json con lista categorias de la request (Viene de LeeCategorias)
			
			JSONObject json = (JSONObject) req.getAttribute("json");
						
			out = resp.getWriter();

			//De aqui se reciben los nuevos campos de la categoria desde un formulario.
		
			IGenericDAO<Integer, Categoria> op = new GenericDAO<Integer,Categoria>();	
			
			Categoria cat = (Categoria) json.get("categoria");

			if (cat!=null) {
				
				op.update(cat);
				
				json.put("mens", "Categoría " + cat.getNombre() + "Editada Correctamente");

			} else {
				json.put("mens", "Error Editando Categoría!");
			}

			out.println(json);
			out.flush();

		} catch (IOException | JSONException e) {
		}
		return null;
	}
}
