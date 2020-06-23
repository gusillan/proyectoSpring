package com.pacoillan.objetos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marcas database table.
 * 
 */
@Entity
@Table(name="marcas")
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMarca;

	private String codigoMarca;

	private String logoMarca;

	private String nombreMarca;

	//bi-directional many-to-one association to Recambio
	@OneToMany(mappedBy="marcaBean")
	private List<Recambio> recambios;

	public Marca() {
	}

	public int getIdMarca() {
		return this.idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getCodigoMarca() {
		return this.codigoMarca;
	}

	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getLogoMarca() {
		return this.logoMarca;
	}

	public void setLogoMarca(String logoMarca) {
		this.logoMarca = logoMarca;
	}

	public String getNombreMarca() {
		return this.nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	public List<Recambio> getRecambios() {
		return this.recambios;
	}

	public void setRecambios(List<Recambio> recambios) {
		this.recambios = recambios;
	}

	public Recambio addRecambio(Recambio recambio) {
		getRecambios().add(recambio);
		recambio.setMarcaBean(this);

		return recambio;
	}

	public Recambio removeRecambio(Recambio recambio) {
		getRecambios().remove(recambio);
		recambio.setMarcaBean(null);

		return recambio;
	}

}