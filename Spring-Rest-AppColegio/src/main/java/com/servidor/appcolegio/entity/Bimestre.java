package com.servidor.appcolegio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Bimestre")
public class Bimestre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_bimestre")
	private Integer idBimestre;

	@Column(name="numero_bimestre")
	private int numeroBimestre;

	@Column(name="anio")
	private int anio;

	@Column(name="fecha_inicio")
	private String fechaInicio;

	@Column(name="fecha_fin")
	private String fechaFin;
	
	// Relación UNO "Bimestre" a MUCHOS "CursoAlumnoBimestre"
	@OneToMany(mappedBy = "bimestre")	// Asociación
	@JsonIgnore							
	private List<CursoAlumnoBimestre> listaCursoAlumnoBimestre;

	public Integer getIdBimestre() {
		return idBimestre;
	}

	public void setIdBimestre(Integer idBimestre) {
		this.idBimestre = idBimestre;
	}

	public int getNumeroBimestre() {
		return numeroBimestre;
	}

	public void setNumeroBimestre(int numeroBimestre) {
		this.numeroBimestre = numeroBimestre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<CursoAlumnoBimestre> getListaCursoAlumnoBimestre() {
		return listaCursoAlumnoBimestre;
	}

	public void setListaCursoAlumnoBimestre(List<CursoAlumnoBimestre> listaCursoAlumnoBimestre) {
		this.listaCursoAlumnoBimestre = listaCursoAlumnoBimestre;
	}

}