package test.json;

import org.json.JSONException;
import org.json.JSONObject;

import friki.tienda.com.Persistencia.Articulo;

/*TEST del funcionamiento de la libreria json-org para generar(PUT) y leer(GET) objetos JSON.

 Con esta libreria se puede encapsular y leer cualquier Objeto que herede de la clase Object 
 (Articulo, Categoria, String...) siempre que se le proporcione una llave.

 NO Funciona para encapsular objetos List ni Arraylist 
 (al menos no con los métodos get y put utilizados aquí)


 Para este tipo de estructuras consultar TestJsonArrays en este mismo package*/

public class TestJson {

	public static void main(String[] args) throws JSONException {

		Articulo art = new Articulo();

		// rellenamos un Articulo a mano
		art.setNombre("Star TShirt");
		art.setCategoria("Camiseta");
		art.setDescripcion("Camiseta de Star Wars Muy Freak");
		art.setIdArticulo(120);
		art.setImagen("url");
		art.setPrecio(9.99);
		art.setNovedad("SI");

		// Imprimimos Nombre Articulo por pantalla
		System.out.println(art.getNombre());

		JSONObject json = new JSONObject();

		// Se transforma en JsonObject
		json.put("prueba", art);

		// Recuperamos el Artículo a partir del JsonObject y imprimimos Nombre
		// por pantalla
		Articulo art2 = (Articulo) json.get("prueba");

		System.out.println(art2.getNombre());

	}

}
