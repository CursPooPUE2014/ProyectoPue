package friki.tienda.com.tienda.operaciones;

import java.util.List;

import friki.tienda.com.Persistencia.UsuarioCliente;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.tienda.accesDAO.ClienteDAO;
import friki.tienda.com.tienda.utilities.UtilitiesTienda;


public class ClienteOperaciones {
	
	// validaciones Registro de Usuario
	public static String preValidarRegistro(UsuarioCliente cliente) {
		String errores = "";
		
		if (cliente.getNombre() == null || cliente.getNombre().equals("")){
			errores = errores + "indique el nombre</br>";
		}
		
		if (cliente.getEmail() == null || cliente.getEmail().equals("")) {
			errores = errores + "indique el e-mail</br>";
			
		} else {
			if(!UtilitiesTienda.isValidEmailAddress(cliente.getEmail())){
				errores = errores + "indique un e-mail v�lido</br>";
			} else {
				if(!existEmail(cliente.getEmail())){
					errores = errores + "El e-mail ya existe en la base de datos</br>";
				}
			}
		}

		if (cliente.getContrasenya() == null || cliente.getContrasenya().equals("")) {
			errores =  errores + "indique la contrase�a</br>";
		} else {
			if(!UtilitiesTienda.isValidPwd(cliente.getContrasenya())){
				errores =  errores + "la contrase�a debe contener"
						+ " al menos 8 caracteres, y estos deben ser"
						+ "alfanum�ricos</br>";
			}
		}
/*		
		if (dirPostal == null || dirPostal.equals("")){
			errores = errores + "indique la direccion</br>";
		}
		*/
		// ###########################################
		/*
		if (telefono != null || !telefono.matches("[0-9]{15,}")){
			errores = errores + "indique un tel�fono v�lido</br>";
		}
*/
		return errores;
	}

	public static String preValidarLogin(UsuarioCliente cliente) {
		String errores = "";
		
		if (cliente.getEmail() == null || cliente.getEmail().equals("")) {
			errores = errores + "indique el e-mail</br>";
			
		} else {
			if(!UtilitiesTienda.isValidEmailAddress(cliente.getEmail())){
				errores = errores + "indique un e-mail v�lido</br>";
			}
		}

		if (cliente.getContrasenya() == null || cliente.getContrasenya().equals("")) {
			errores =  errores + "indique la contrase�a</br>";
		} else {
			if(!UtilitiesTienda.isValidPwd(cliente.getContrasenya())){
				errores =  errores + "la contrase�a debe contener"
						+ " al menos 8 caracteres, y estos deben ser"
						+ "alfanum�ricos</br>";
			}
		}
		
		return errores;
	}
	
	private static boolean existEmail(String email){
		ClienteDAO<Integer, UsuarioCliente> dao =  new ClienteDAO<Integer, UsuarioCliente>();
		List<UsuarioCliente> lista;
		lista = dao.findByEmail(UsuarioCliente.class, email);

		if(lista != null && lista.size() > 0){
			return true;
		} else {
			return false;
		}	
	}
	
	public static UsuarioCliente existLogin(UsuarioCliente cliente){
		ClienteDAO<Integer, UsuarioCliente> dao =  new ClienteDAO<Integer, UsuarioCliente>();
		List<UsuarioCliente> lista = null;
		/*
		 // de momento no se encripta el pwe
			try {
				contrasenya = pwdEnc.encrypt(contrasenya);	
			} catch (Exception e) {
				e.printStackTrace();
				// si se produce error retornamos nulo
				return null;
			}
		 */
		lista = dao.findByLogin(UsuarioCliente.class, cliente.getEmail(), cliente.getContrasenya());

		if(lista != null && lista.size() > 0){
			UsuarioCliente usuario = lista.get(0);
			return usuario;
		} else {
			return null;
		}
		
	}

	public static UsuarioCliente saveCliente(UsuarioCliente cliente) {
		GenericDAO<Integer, UsuarioCliente> gdao =  new GenericDAO<Integer, UsuarioCliente>();
		UsuarioCliente savedUser = gdao.save(cliente);		
		return savedUser;
	}


}
