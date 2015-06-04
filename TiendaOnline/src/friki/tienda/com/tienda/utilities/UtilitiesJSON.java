package friki.tienda.com.tienda.utilities;

import org.json.JSONException;
import org.json.JSONObject;



import java.util.ArrayList;
import java.util.List;

public class UtilitiesJSON {

	public static <T> List<T> jsonArrayReader(JSONObject json)
			throws JSONException {

		List<Object> listObj = new ArrayList<Object>();
		Object obj = null;

		int i = 0;

		while (!json.isNull("llave" + i)) {
			obj = (Object) json.get("llave" + i);
			listObj.add(obj);
			i++;
		}
		return (List<T>) listObj;
	}

	public static <T> JSONObject jsonArrayGenerator(List<T> llista)
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
