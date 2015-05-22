package friki.tienda.com.tienda.controladores.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;


import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.global.services.Md5Encryption;
import friki.tienda.com.tienda.beans.loginClienteBean;

public class LoginClienteAction extends Action {
	public ActionForward getJSONData(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json");
		
		Md5Encryption pwdEnc = null;
		
		String username = request.getParameter("email");
		String pwd = request.getParameter("contrasenya");

		pwd = pwdEnc.encrypt(pwd);
		
		System.out.println("###############");
		System.out.println("pwd: " + pwd);
		System.out.println("###############");
		
		//...
		
		//jsonObj.write(response.getWriter());
			
				return null;


		}
}
