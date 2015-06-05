package friki.tienda.com.backoffice.accions;


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

import friki.tienda.com.Persistencia.Usuarioscliente;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class AltaUsuariocliente extends Action {

	 public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) throws JSONException {
		

			JSONObject json = new JSONObject();

			resp.setContentType("application/json");

			PrintWriter out = null;

			try {
				
				out = resp.getWriter();

				Usuarioscliente usuclient = (Usuarioscliente) form;

				IGenericDAO<Integer, Usuarioscliente> clientdao = new GenericDAO<Integer, Usuarioscliente>();

				clientdao.save(usuclient);

				json.put("mens", "Art�culo a�adido con ID: " + usuclient.getIdUsuario());

			} catch (IOException | JSONException e) {

				json.put("mens", "Error! Art�culo NO a�adido");
			}

			finally {

				out.println(json);
				out.flush();

			}

			return null;

		}
	}

