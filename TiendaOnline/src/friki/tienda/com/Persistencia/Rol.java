package friki.tienda.com.Persistencia;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.struts.action.ActionForm;

import friki.tienda.com.daogenerico.IPersistent;

import java.util.List;

 
/**
 * The persistent class for the rol database table.
 * 
 */  
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol extends ActionForm implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rol")
	private int idRol;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to UsuarioAdministrador
	@OneToMany(mappedBy="rol")
	private List<UsuarioAdministrador> usuarioadministradors;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioAdministrador> getUsuarioadministradors() {
		return this.usuarioadministradors;
	}

	public void setUsuarioadministradors(List<UsuarioAdministrador> usuarioadministradors) {
		this.usuarioadministradors = usuarioadministradors;
	}

	public UsuarioAdministrador addUsuarioadministrador(UsuarioAdministrador usuarioadministrador) {
		getUsuarioadministradors().add(usuarioadministrador);
		usuarioadministrador.setRol(this);

		return usuarioadministrador;
	}

	public UsuarioAdministrador removeUsuarioadministrador(UsuarioAdministrador usuarioadministrador) {
		getUsuarioadministradors().remove(usuarioadministrador);
		usuarioadministrador.setRol(null);

		return usuarioadministrador;
	}

	@Override
	public Integer getKey() {
		return this.idRol;
	}

}