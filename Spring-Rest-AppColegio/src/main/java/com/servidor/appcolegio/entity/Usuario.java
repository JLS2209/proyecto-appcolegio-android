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
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_usuario")
	private Integer idUsuario;

	// Relación MUCHOS "Usuario" a UNO "TipoUsuario"
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipoUsuario; // Asociación

	@Column(name="nombre")
	private String nombre;

	@Column(name="paterno")
	private String paterno;

	@Column(name="materno")
	private String materno;

	@Column(name="usuario")
	private String usuario;

	@Column(name="clave")
	private String clave;

	@Column(name="foto")
	private String foto;

	@Column(name="correo")
	private String correo;

	@Column(name="telefono")
	private String telefono;

	// Relación MUCHOS "Usuario" a UNO "Aula"
	@ManyToOne
	@JoinColumn(name="id_aula")
	private Aula aula;

	@Column(name="fecha_incorporacion")
	private String fechaIncorporacion;
	
	// Relación UNO "Usuario(docente)" a MUCHOS "CursoAula"
	@OneToMany(mappedBy = "docente")	// Asociación
	@JsonIgnore							
	private List<CursoAula> listaCursosAula;
	
	// Relación UNO "Usuario(alumno)" a MUCHOS "CursoAlumnoBimestre"
	@OneToMany(mappedBy = "alumno")		// Asociación
	@JsonIgnore							
	private List<CursoAlumnoBimestre> listaCursoAlumnoBimestre;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(String fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public List<CursoAula> getListaCursosAula() {
		return listaCursosAula;
	}

	public void setListaCursosAula(List<CursoAula> listaCursosAula) {
		this.listaCursosAula = listaCursosAula;
	}

	public List<CursoAlumnoBimestre> getListaCursoAlumnoBimestre() {
		return listaCursoAlumnoBimestre;
	}

	public void setListaCursoAlumnoBimestre(List<CursoAlumnoBimestre> listaCursoAlumnoBimestre) {
		this.listaCursoAlumnoBimestre = listaCursoAlumnoBimestre;
	}

}