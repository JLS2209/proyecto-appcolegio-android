package com.servidor.appcolegio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Aula")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_aula")
	private Integer idAula;

	// Relación MUCHOS "Aula" a UNO "Grado"
	@ManyToOne
	@JoinColumn(name="id_grado")
	private Grado grado; // Asociación

	@Column(name="seccion")
	private String seccion;
	
	
	// Relación UNO "Aula" a MUCHOS "Usuario"
	@OneToMany(mappedBy = "aula")	// Asociación
	@JsonIgnore							
	private List<Usuario> listaUsuarios;
	
	// Relación UNO "Aula" a MUCHOS "CursoAula"
	@OneToMany(mappedBy = "aulaCurso")	// Asociación
	@JsonIgnore							
	private List<CursoAula> listaCursosAula;

	public Integer getIdAula() {
		return idAula;
	}

	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<CursoAula> getListaCursosAula() {
		return listaCursosAula;
	}

	public void setListaCursosAula(List<CursoAula> listaCursosAula) {
		this.listaCursosAula = listaCursosAula;
	}
}