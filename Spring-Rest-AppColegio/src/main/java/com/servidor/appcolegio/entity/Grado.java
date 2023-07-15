package com.servidor.appcolegio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Grado")
public class Grado {
	@Id
	@Column(name="id_grado")
	private Integer idGrado;

	@Column(name="nombre_grado")
	private String nombreGrado;
	
	// Relación UNO "Grado" a MUCHOS "Aula"
	@OneToMany(mappedBy = "grado")		// Asociación
	@JsonIgnore							
	private List<Aula> listaAulas;

	public Integer getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	public String getNombreGrado() {
		return nombreGrado;
	}

	public void setNombreGrado(String nombreGrado) {
		this.nombreGrado = nombreGrado;
	}

	public List<Aula> getListaAulas() {
		return listaAulas;
	}

	public void setListaAulas(List<Aula> listaAulas) {
		this.listaAulas = listaAulas;
	}

}