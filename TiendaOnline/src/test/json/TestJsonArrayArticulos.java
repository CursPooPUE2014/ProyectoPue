package test.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import friki.tienda.com.Persistencia.Articulo;

public class TestJsonArrayArticulos {

	public static void main(String[] args) throws JSONException {

		JSONObject json = new JSONObject();

		Articulo art = new Articulo();
		Articulo art2 = new Articulo();

		List<Articulo> listArt = new ArrayList<Articulo>();

		art.setNombre("Star TShirt");
		art.setCategoria("Camiseta");
		art.setDescripcion("Camiseta de Star Wars Muy Freak");
		art.setIdArticulo(120);
		art.setImagen("url");
		art.setPrecio(9.99);
		art.setNovedad("SI");

		art2.setNombre("GOT Gorra");
		art2.setCategoria("Gorra");
		art2.setDescripcion("Gorra de GOT: Winter Is Coming");
		art2.setIdArticulo(121);
		art2.setImagen("url2");
		art2.setPrecio(19.99);
		art2.setNovedad("NO");

		listArt.add(art);
		listArt.add(art2);
		
		System.out.println(art.getNombre());
		System.out.println(art2.getNombre());

		json = jsonArrayGenerator(listArt);

		List<Articulo> listArt2 = jsonArrayReader(json);
		
		art = listArt2.get(0);
		art2 = listArt2.get(1);
		
		System.out.println(art.getNombre());
		System.out.println(art2.getNombre());

	}

	private static List<Articulo> jsonArrayReader(JSONObject json)
			throws JSONException {

		List<Articulo> listArt = new ArrayList<Articulo>();
		Articulo art = null;

		int i = 0;

		while (!json.isNull("llave" + i)) {
			art = (Articulo) json.get("llave" + i);
			listArt.add(art);
			i++;
		}

		return listArt;
	}

	private static JSONObject jsonArrayGenerator(List<Articulo> llista)
			throws JSONException {

		int i = 0;
		JSONObject json = new JSONObject();

		for (Object obj : llista) {

			json.put("llave" + i, obj);
			i++;
		}
		return json;

	}

}
