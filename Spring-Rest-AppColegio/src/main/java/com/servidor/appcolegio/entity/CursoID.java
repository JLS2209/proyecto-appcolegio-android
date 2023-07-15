package com.servidor.appcolegio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Curso_ID")
public class CursoID {
	@Id
	@Column(name="id_curso")
	private Integer idCurso;

	@Column(name="nombre_curso")
	private String nombreCurso;
	
	// Relación UNO "CursoID" a MUCHOS "CursoAula"
	@OneToMany(mappedBy = "curso")		// Asociación
	@JsonIgnore							
	private List<CursoAula> listaCursosAula;

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public List<CursoAula> getListaCursosAula() {
		return listaCursosAula;
	}

	public void setListaCursosAula(List<CursoAula> listaCursosAula) {
		this.listaCursosAula = listaCursosAula;
	}

}