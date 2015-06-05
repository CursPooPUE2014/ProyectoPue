package friki.tienda.com.backoffice.actions.gestionAdmin;

//import operaciones.*;
import org.apache.struts.action.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.Usuariosadministrador;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class ConsultarAdministradors extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) throws JSONException {	
		JSONObject json = new JSONObject();

		resp.setContentType("application/json");

		PrintWriter out = null;

		try {
			out = resp.getWriter();

			Usuariosadministrador adm = (Usuariosadministrador) form;

			IGenericDAO <Integer, Usuariosadministrador> admDao = new GenericDAO<Integer, Usuariosadministrador>();

			adm = admDao.findByKey(adm, Integer.class);

			json.put("administrador", adm);

		} catch (IOException | JSONException e) {

			json.put("mens", "Error! Administrador NO Encontrado");
		}
		
		finally {
			
			out.println(json);
			out.flush();
			
		}

		return null;
	}
		
}