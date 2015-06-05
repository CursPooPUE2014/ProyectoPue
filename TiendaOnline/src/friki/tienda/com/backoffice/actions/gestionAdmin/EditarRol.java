package friki.tienda.com.backoffice.actions.gestionAdmin;

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

import friki.tienda.com.Persistencia.Role;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class EditarRol extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) {

	
		resp.setContentType("application/json");

		PrintWriter out;

		try {
			
			//Obtenemos json con lista categorias de la request (Viene de LeeCategorias)
			
			JSONObject json = (JSONObject) req.getAttribute("json");
						
			out = resp.getWriter();

			//De aqui se reciben los nuevos campos de la categoria desde un formulario.
		
			IGenericDAO<Integer, Role> rolDao = new GenericDAO<Integer,Role>();	
			
			Role rolBean = (Role) json.get("rol");

			if (rolBean!=null) {
				
				rolDao.update(rolBean);
				
				json.put("mens", "Rol " + rolBean.getNombre() + "Editada Correctamente");

			} else {
				json.put("mens", "Error Editando Rol!");
			}

			out.println(json);
			out.flush();

		} catch (IOException | JSONException e) {
		}
		return null;
	}
}
