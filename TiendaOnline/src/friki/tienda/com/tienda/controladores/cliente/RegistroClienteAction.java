package friki.tienda.com.tienda.controladores.cliente;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.Persistencia.UsuarioCliente;
import friki.tienda.com.tienda.operaciones.ClienteOperaciones;

public class RegistroClienteAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception {
		// establecemos tipo de respuesta json
		response.setContentType("application/json");
		
		// recuperamos los parámetros de la request y creamos el objeto
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String nif = request.getParameter("nif");
		String contrasenya = request.getParameter("contrasenya");
		String dirPostal = request.getParameter("dirPostal");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		
		
		// creamos objeto json que enviaremos en la response		
		JSONObject js = new JSONObject();
		
		UsuarioCliente cliente = new UsuarioCliente(nombre,contrasenya,email);
		
		//Comprobamos si es válido, o sea que no ha saltado
		// la excepción del encrypt
		if(cliente.getIsValid()){
			// vemos si se han introducido datos correctos en el form
			String err = ClienteOperaciones.preValidarRegistro(cliente);
			
			// si hay errores al validar datos añadimos msg al json
			// si no, comprobamos si el usuario existe en la BBDD
			if(err != null){
				js.put("errores",err);
			} else {
				// añadimos el resto de campos al cliente
				cliente.setApellido1(apellido1);
				cliente.setApellido2(apellido2);
				cliente.setNif(nif);
				cliente.setDirPostal(dirPostal);
				cliente.setTelefono(telefono);

				UsuarioCliente usuario = ClienteOperaciones.saveCliente(cliente);		
				// si ha habido error al crear el cliente en la BBDD cargamos error en el json
				// si no cargamos el usuario en la sesion
				if(usuario == null ){
					js.put("errores","Error al crear el usuario");
				} else {
					/* cargo el cliente en la sesion 
					 * retorno el json
					 */
					js.put("errores","");
					js.put("cliente",usuario);
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("cliente", usuario);
				}
			}
		} else {
			js.put("errores","Error al crear el Usuario. </br>"
					+ "Vuelva a intentarlo");
		}

		 
		PrintWriter pw = response.getWriter();
		pw.write(js.toString());
		pw.flush();
		pw.close();

		return null;
		
	}
}