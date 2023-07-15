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
@Table(name="Curso_Aula")
public class CursoAula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_curso_aula")
	private Integer idCursoAula;

	// Relación MUCHOS "CursoAula" a UNO "CursoID"
	@ManyToOne
	@JoinColumn(name="id_curso")
	private CursoID curso; // Asociación

	// Relación MUCHOS "CursoAula" a UNO "Aula"
	@ManyToOne
	@JoinColumn(name="id_aula")
	private Aula aulaCurso; // Asociación

	// Relación MUCHOS "CursoAula" a UNO "Usuario(docente)"
	@ManyToOne
	@JoinColumn(name="id_docente")
	private Usuario docente; // Asociación
	
	
	// Relación UNO "CursoAula" a MUCHOS "CursoAlumnoBimestre"
	@OneToMany(mappedBy = "cursoAula")	// Asociación
	@JsonIgnore							
	private List<CursoAlumnoBimestre> listaCursoAlumnoBimestre;

	public Integer getIdCursoAula() {
		return idCursoAula;
	}

	public void setIdCursoAula(Integer idCursoAula) {
		this.idCursoAula = idCursoAula;
	}

	public CursoID getCurso() {
		return curso;
	}

	public void setCurso(CursoID curso) {
		this.curso = curso;
	}

	public Aula getAulaCurso() {
		return aulaCurso;
	}

	public void setAulaCurso(Aula aulaCurso) {
		this.aulaCurso = aulaCurso;
	}

	public Usuario getDocente() {
		return docente;
	}

	public void setDocente(Usuario docente) {
		this.docente = docente;
	}

	public List<CursoAlumnoBimestre> getListaCursoAlumnoBimestre() {
		return listaCursoAlumnoBimestre;
	}

	public void setListaCursoAlumnoBimestre(List<CursoAlumnoBimestre> listaCursoAlumnoBimestre) {
		this.listaCursoAlumnoBimestre = listaCursoAlumnoBimestre;
	}

}
