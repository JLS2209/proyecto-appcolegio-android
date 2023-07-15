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
@Table(name="Curso_Alumno_Bimestre")
public class CursoAlumnoBimestre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_curso_alumno_bimestre")
	private Integer idCursoAlumnoBimestre;

	// Relación MUCHOS "CursoAlumnoBimestre" a UNO "CursoAula"
	@ManyToOne
	@JoinColumn(name="id_curso_aula")
	private CursoAula cursoAula; // Asociación

	// Relación MUCHOS "CursoAlumnoBimestre" a UNO "Bimestre"
	@ManyToOne
	@JoinColumn(name="id_bimestre")
	private Bimestre bimestre; // Asociación

	// Relación MUCHOS "CursoAlumnoBimestre" a UNO "Usuario(alumno)"
	@ManyToOne
	@JoinColumn(name="id_alumno")
	private Usuario alumno; // Asociación

	
	@Column(name="prom_bimestral")
	private double promBimestral;
	
	// Relación UNO "CursoAlumnoBimestre" a MUCHOS "Nota"
	@OneToMany(mappedBy = "cursoAlumnoBimestre")	// Asociación
	@JsonIgnore							
	private List<Nota> listaNotas;

	public Integer getIdCursoAlumnoBimestre() {
		return idCursoAlumnoBimestre;
	}

	public void setIdCursoAlumnoBimestre(Integer idCursoAlumnoBimestre) {
		this.idCursoAlumnoBimestre = idCursoAlumnoBimestre;
	}

	public CursoAula getCursoAula() {
		return cursoAula;
	}

	public void setCursoAula(CursoAula cursoAula) {
		this.cursoAula = cursoAula;
	}

	public Bimestre getBimestre() {
		return bimestre;
	}

	public void setBimestre(Bimestre bimestre) {
		this.bimestre = bimestre;
	}

	public Usuario getAlumno() {
		return alumno;
	}

	public void setAlumno(Usuario alumno) {
		this.alumno = alumno;
	}

	public double getPromBimestral() {
		return promBimestral;
	}

	public void setPromBimestral(double promBimestral) {
		this.promBimestral = promBimestral;
	}

	public List<Nota> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(List<Nota> listaNotas) {
		this.listaNotas = listaNotas;
	}

}