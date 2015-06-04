package test.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.tienda.utilities.*;

public class TestJsonArrayArticulos {

	public static void main(String[] args) throws JSONException {

		JSONObject json = new JSONObject();

		Articulo art = new Articulo();
		Articulo art2 = new Articulo();

		List<Articulo> listArt = new ArrayList<Articulo>();
		//creem dos articles  a partir de JavaBeans
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
		//afegim  els articles a la llista
		listArt.add(art);
		listArt.add(art2);

		System.out.println(art.getNombre());
		System.out.println(art2.getNombre());

		//passem a array a objecte json
		json = UtilitiesJSON.jsonArrayGenerator(listArt);
		
		// passem objecte json a array de java
		List<Articulo> listArt2 = UtilitiesJSON.jsonArrayReader(json);

		//comprovem que es s'ha obtingut correctament de nou els elements del array
		for (Articulo ar : listArt2) {			
			System.out.println(ar.getNombre()+"-"+ar.getPrecio()+"-"+ar.getTipoDeProducto());						
		}

	}


}
