package com.servidor.appcolegio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Tipo_Usuario")
public class TipoUsuario {
	@Id
	@Column(name="id_tipo_usuario")
	private Integer idTipoUsuario;

	@Column(name="tipo_usuario")
	private String tipoUsuario;
	
	// Relación UNO "TipoUsuario" a MUCHOS "Usuario"
	@OneToMany(mappedBy = "tipoUsuario")	// Asociación
	@JsonIgnore								
	private List<Usuario> listaUsuarios;

	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
