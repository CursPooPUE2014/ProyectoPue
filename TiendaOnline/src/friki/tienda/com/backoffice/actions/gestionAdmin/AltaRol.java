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

import friki.tienda.com.Persistencia.Rol;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class AltaRol extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) throws JSONException {

		JSONObject json = new JSONObject();

		resp.setContentType("application/json");

		PrintWriter out = null;

		try {
			
			out = resp.getWriter();

			Rol rolBean = (Rol) form;
			
			IGenericDAO<Integer, Rol> adminDao = new GenericDAO<Integer, Rol>();

			adminDao.save(rolBean);

			json.put("mens", "Rol añadido con ID: " + rolBean.getIdRol());

		} catch (IOException | JSONException e) {

			json.put("mens", "Error! Administrador NO añadido");
		}

		finally {

			out.println(json);
			out.flush();

		}

		return null;

	}
		
		

	
}