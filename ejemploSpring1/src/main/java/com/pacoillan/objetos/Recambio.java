package com.pacoillan.objetos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recambios database table.
 * 
 */
@Entity
@Table(name="recambios")
@NamedQuery(name="Recambio.findAll", query="SELECT r FROM Recambio r")
public class Recambio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRecambio;

	private String descripcion;

	private String descripcion2;

	private double dto;

	@Lob
	private String info;

	private double pvp;

	private double pvpr;

	private String referencia;

	private double stock;

	private String ubicacion;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="marca")
	private Marca marcaBean;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoriaBean;

	//bi-directional many-to-one association to Familia
	@ManyToOne
	@JoinColumn(name="familia")
	private Familia familiaBean;

	public Recambio() {
	}

	public int getIdRecambio() {
		return this.idRecambio;
	}

	public void setIdRecambio(int idRecambio) {
		this.idRecambio = idRecambio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion2() {
		return this.descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public double getDto() {
		return this.dto;
	}

	public void setDto(double dto) {
		this.dto = dto;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getPvp() {
		return this.pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	public double getPvpr() {
		return this.pvpr;
	}

	public void setPvpr(double pvpr) {
		this.pvpr = pvpr;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public double getStock() {
		return this.stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Marca getMarcaBean() {
		return this.marcaBean;
	}

	public void setMarcaBean(Marca marcaBean) {
		this.marcaBean = marcaBean;
	}

	public Categoria getCategoriaBean() {
		return this.categoriaBean;
	}

	public void setCategoriaBean(Categoria categoriaBean) {
		this.categoriaBean = categoriaBean;
	}

	public Familia getFamiliaBean() {
		return this.familiaBean;
	}

	public void setFamiliaBean(Familia familiaBean) {
		this.familiaBean = familiaBean;
	}

}