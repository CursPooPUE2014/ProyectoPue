package friki.tienda.com.tienda.controladores.login;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.tienda.beans.LoginClienteBean;
import friki.tienda.com.tienda.beans.ClienteBean;

public class LoginClienteAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception {
		// establecemos tipo de respuesta json
		response.setContentType("application/json");
		
		// recuperamos los parámetros de la request y creamos el objeto
		String username = request.getParameter("email");
		String pwd = request.getParameter("contrasenya");
		
		LoginClienteBean usuario = new LoginClienteBean(username,pwd);
		
		// creamos objeto json que enviaremos en la response
		
		JSONObject js = null;
		
		// vemos si se han introducido datos correctos en el form
		String err = usuario.preValidar();
		
		// si hay errores al validar datos añadimos msg al json
		// si no, comprobamos si el usuario existe en la BBDD
		if(err != null){
			js.accumulate("errores",err);
		} else {
			ClienteBean cliente = usuario.exist();
			// si el cliente es nulo añadimos al json msg de error
			// si no cargamos el usuario en la sesion
			if(cliente == null){
				js.accumulate("errores","Usuario o contraseña incorrecto");
			} else {
				// cargo el cliente
			}
		}

		 
		PrintWriter pw = response.getWriter();
		//pw.write("({\"listaObjetos\":" + js.toString() + "})");
		pw.write(js.toString());
		pw.flush();
		pw.close();

		return null;
		
	}
	
/*
	private String preValidar(String email,String pwd) {
		// comprobamos que usuario y pwd no vengan nulos
		// y que el email tenga formato correcto
		String errores = "";
		
		if (email == null || email.equals("")) {
			errores = errores + "indique el e-mail";
			
		} else {
			if(!isValidEmailAddress(email)){
				errores = errores + "indique un e-mail válido";
			}
		}

		if (pwd == null || pwd.equals("")) {
			errores =  errores + "indique la contraseña";
		}
		
		return errores;
	}
	
	private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
*/	
	private String pagRedirect(){

		// segun de donde vengamos redirigimos a una página o a otra		
		return null;
	}
}