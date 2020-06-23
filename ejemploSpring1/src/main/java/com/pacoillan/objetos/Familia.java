package com.pacoillan.objetos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the familias database table.
 * 
 */
@Entity
@Table(name="familias")
@NamedQuery(name="Familia.findAll", query="SELECT f FROM Familia f")
public class Familia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idFamilia;

	private String codigoFamilia;

	private String nombreFamilia;

	//bi-directional many-to-one association to Recambio
	@OneToMany(mappedBy="familiaBean")
	private List<Recambio> recambios;

	public Familia() {
	}

	public int getIdFamilia() {
		return this.idFamilia;
	}

	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getCodigoFamilia() {
		return this.codigoFamilia;
	}

	public void setCodigoFamilia(String codigoFamilia) {
		this.codigoFamilia = codigoFamilia;
	}

	public String getNombreFamilia() {
		return this.nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	public List<Recambio> getRecambios() {
		return this.recambios;
	}

	public void setRecambios(List<Recambio> recambios) {
		this.recambios = recambios;
	}

	public Recambio addRecambio(Recambio recambio) {
		getRecambios().add(recambio);
		recambio.setFamiliaBean(this);

		return recambio;
	}

	public Recambio removeRecambio(Recambio recambio) {
		getRecambios().remove(recambio);
		recambio.setFamiliaBean(null);

		return recambio;
	}

}