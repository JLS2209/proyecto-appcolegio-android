package com.servidor.appcolegio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Examen")
public class Examen {
	@Id
	@Column(name="id_examen")
	private Integer idExamen;

	@Column(name="nombre_examen")
	private String nombreExamen;
	
	// Relación UNO "Examen" a MUCHOS "Nota"
	@OneToMany(mappedBy = "examen")		// Asociación
	@JsonIgnore							
	private List<Nota> listaNotas;

	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	public String getNombreExamen() {
		return nombreExamen;
	}

	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}

	public List<Nota> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(List<Nota> listaNotas) {
		this.listaNotas = listaNotas;
	}

}