package com.pacoillan.objetos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCategoria;

	private String codigoCategoria;

	private String nombreCategoria;

	//bi-directional many-to-one association to Recambio
	@OneToMany(mappedBy="categoriaBean")
	private List<Recambio> recambios;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<Recambio> getRecambios() {
		return this.recambios;
	}

	public void setRecambios(List<Recambio> recambios) {
		this.recambios = recambios;
	}

	public Recambio addRecambio(Recambio recambio) {
		getRecambios().add(recambio);
		recambio.setCategoriaBean(this);

		return recambio;
	}

	public Recambio removeRecambio(Recambio recambio) {
		getRecambios().remove(recambio);
		recambio.setCategoriaBean(null);

		return recambio;
	}

}