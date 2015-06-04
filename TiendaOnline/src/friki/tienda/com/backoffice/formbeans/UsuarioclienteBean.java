package friki.tienda.com.backoffice.formbeans;

import org.apache.struts.action.ActionForm;

public class UsuarioclienteBean extends ActionForm{
	private int idUsuario;
	private String email;
	private String nombre;
	private String contrasenya;
	private String dirPostal;
	private int telefono;
	
	public UsuarioclienteBean() {
	}

	
	public UsuarioclienteBean(int idUsuario, String email, String nombre,
			String contrasenya, String dirPostal, int telefono) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.dirPostal = dirPostal;
		this.telefono = telefono;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getDirPostal() {
		return dirPostal;
	}

	public void setDirPostal(String dirPostal) {
		this.dirPostal = dirPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		String mensaje="El usuario cliente: "+getNombre()+" tiene clave: "+getIdUsuario()+" con correo: "+getEmail()+" telefono: "+getTelefono()+
				" y dirección: " + getDirPostal();
        return mensaje;
		
	}
}
