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

public class AltaCategoria extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws JSONException {

		JSONObject json = new JSONObject();

		resp.setContentType("application/json");

		PrintWriter out = null;

		try {
			out = resp.getWriter();

			Categoria cat = (Categoria) form;
			IGenericDAO<Integer, Categoria> catdao = new GenericDAO<Integer, Categoria>();

			catdao.save(cat);

			json.put("mens",
					"Categoría añadida con ID: " + cat.getIdCategoria());

		} catch (IOException | JSONException e) {

			json.put("mens", "Error! Categoría NO añadida");
		}

		finally {

			out.println(json);
			out.flush();

		}

		return null;

	}
}
