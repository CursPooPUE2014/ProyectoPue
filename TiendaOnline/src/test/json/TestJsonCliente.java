package test.json;

import org.json.JSONException;
import org.json.JSONObject;

import friki.tienda.com.backoffice.formbeans.UsuarioclienteBean;

/*TEST del funcionamiento de la libreria json-org para generar(PUT) y leer(GET) objetos JSON.

 Con esta libreria se puede encapsular y leer cualquier Objeto que herede de la clase Object 
 (Articulo, Categoria, String...) siempre que se le proporcione una llave.

 NO Funciona para encapsular objetos List ni Arraylist 
 (al menos no con los métodos get y put utilizados aquí)


 Para este tipo de estructuras consultar TestJsonArrays en este mismo package*/

public class TestJsonCliente {

	public static void main(String[] args) throws JSONException {

		UsuarioclienteBean usb1 = new UsuarioclienteBean();

		// rellenamos un Cliente a mano
		usb1.setIdUsuario(1);
		usb1.setNombre("Albert");
		usb1.setEmail("alberturi@gmail.com");
		usb1.setContrasenya("Albert");
		usb1.setDirPostal("Av/Diagonal 120");
		usb1.setTelefono(610294678);
		
		// Imprimimos tostring por pantalla
		System.out.println(usb1);

		JSONObject json = new JSONObject();

		// Se transforma en JsonObject
		json.put("cliente1", usb1);

		// Recuperamos el Cliente a partir del JsonObject y imprimimos todos lo datos
		// por pantalla
		UsuarioclienteBean usb2 = (UsuarioclienteBean) json.get("prueba");

		System.out.println(usb2);
		

	}



}
