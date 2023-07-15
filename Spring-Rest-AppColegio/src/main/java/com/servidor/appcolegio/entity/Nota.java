package com.servidor.appcolegio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Nota")
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_nota")
	private Integer idNota;
	
	// Relación MUCHOS "Nota" a UNO "CursoAlumnoBimestre"
	@ManyToOne
	@JoinColumn(name="id_curso_alumno_bimestre")
	private CursoAlumnoBimestre cursoAlumnoBimestre; // Asociación

	// Relación MUCHOS "Nota" a UNO "Examen"
	@ManyToOne
	@JoinColumn(name="id_examen")
	private Examen examen; // Asociación

	@Column(name="valor_nota")
	private int valorNota;

	public Integer getIdNota() {
		return idNota;
	}

	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	public CursoAlumnoBimestre getCursoAlumnoBimestre() {
		return cursoAlumnoBimestre;
	}

	public void setCursoAlumnoBimestre(CursoAlumnoBimestre cursoAlumnoBimestre) {
		this.cursoAlumnoBimestre = cursoAlumnoBimestre;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public int getValorNota() {
		return valorNota;
	}

	public void setValorNota(int valorNota) {
		this.valorNota = valorNota;
	}

}