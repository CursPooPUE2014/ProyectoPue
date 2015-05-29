package friki.tienda.com.backoffice.accions;

//import operaciones.*;
import org.apache.struts.action.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friki.tienda.com.backoffice.formbeans.UsuarioclienteBean;


public class EliminaUsuariocliente extends Action {

	 public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) {
		
		resp.setContentType("application/json");
		UsuarioclienteBean usuariocliente =(UsuarioclienteBean) form;
	
		//conectar amb el DAO i fer un delete del usuari
		
		// Get the printwriter object from response to write the required json object to the output stream
		//cridar a la classe dao per a eliminar per id 
		PrintWriter out;
		try {
			out = resp.getWriter();
		
			out.print("Client eliminat de manera satisfactoria");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	//(aix� es necessari perqu� si no retornem null, passaria el control de nou al servlet d'struts);

	}
		
}