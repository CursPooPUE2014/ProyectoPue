package test.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import friki.tienda.com.Persistencia.Articulo;

public class TestJson {

	public static void main(String[] args) throws JSONException {

		Articulo art = new Articulo();

		List<Articulo> listArt = new ArrayList<Articulo>();

		art.setNombre("Star TShirt");
		art.setCategoria("Camiseta");
		art.setDescripcion("Camiseta de Star Wars Muy Freak");
		art.setIdArticulo(120);
		art.setImagen("url");
		art.setPrecio(9.99);
		art.setNovedad("SI");

		JSONObject json = new JSONObject();

		json.put("prueba", art);

		System.out.println(art.getNombre());

		Articulo art2 = (Articulo) json.get("prueba");

		System.out.println(art2.getNombre());

	}

}
