package friki.tienda.com.tienda.beans;

import org.apache.struts.action.ActionForm;

public class ArticuloSearch extends ActionForm{
	private static final long serialVersionUID = 1L;
	private String cadena;

	public ArticuloSearch() {}
	public ArticuloSearch(String cadena) {
		this.cadena = cadena;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

}
