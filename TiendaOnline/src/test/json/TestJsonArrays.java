package test.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import friki.tienda.com.Persistencia.Articulo;

public class TestJsonArrays {

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

		listArt.add(art);
		listArt.add(art);

		JSONObject json = new JSONObject();
		
		//jsonArrayGenerator(listArt);
		
		json.put("prueba", art);
		json.put("listArt", listArt);

		System.out.println(art.getNombre());
/*
		// Articulo art2 = (Articulo) json.get("prueba");
		@SuppressWarnings("unchecked")
		
		List<Articulo> listArt2 = jsonArrayReader(json);
		
			
		Articulo art3 = lista2.get(0);
		Articulo art4 = lista2.get(1);

		System.out.println(art3.getNombre());
		System.out.println(art4.getCategoria());
	}

	private static List<Articulo> jsonArrayReader(JSONObject json) throws JSONException {

		List<Articulo> listArt = new ArrayList<Articulo>();
		
		for (Articulo arti : listArt)
			
		{
			
			
		}
		
		Articulo art = (Articulo)json.get("listArt");
		
		return null;
	}

	private static JSONObject jsonArrayGenerator(List<Articulo> llista) throws JSONException {

		int i = 0;
		JSONObject json = new JSONObject();
		
		for (Object obj : llista) {

			json.put("parametro" + i, obj);
			i++;
		}
		return json;
		
	}*/
	}
}
