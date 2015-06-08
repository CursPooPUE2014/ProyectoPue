package friki.tienda.com.backoffice.actions.gestionCliente;


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

import friki.tienda.com.Persistencia.UsuarioCliente;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class ModificaUsuariocliente extends Action {

	 public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) throws JSONException {
		

			JSONObject json = new JSONObject();

			resp.setContentType("application/json");

			PrintWriter out = null;

			try {
				
				out = resp.getWriter();

				UsuarioCliente usuclient = (UsuarioCliente) form;

				IGenericDAO<Integer, UsuarioCliente> clientdao = new GenericDAO<Integer, UsuarioCliente>();

				clientdao.update(usuclient);

				json.put("mens", "Cliente modificado: " + usuclient.getIdUsuario());

			} catch (IOException | JSONException e) {

				json.put("mens", "Error! Cliente NO ha podido ser modificado");
			}

			finally {

				out.println(json);
				out.flush();

			}

			return null;

		}
}
