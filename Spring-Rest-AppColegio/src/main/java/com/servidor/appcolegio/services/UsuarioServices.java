package com.servidor.appcolegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.appcolegio.entity.Aula;
import com.servidor.appcolegio.entity.TipoUsuario;
import com.servidor.appcolegio.entity.Usuario;
import com.servidor.appcolegio.repository.UsuarioRepository;

@Service
public class UsuarioServices {
	// Los servicios trabajan con los repositorios
	@Autowired										// Inyección de dependencia
	private UsuarioRepository repo;
	
	// Método para listar todos los usuarios
	public List<Usuario> listarTodos() {
		return repo.findAll();
	}
	
	// Método para buscar un usuario por su Id
	public Usuario buscarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	// Método para buscar un usuario por sus credenciales de login
	public Usuario buscarPorLogin(String usuario, String clave, TipoUsuario tipoUsuario) {
		return repo.findByUsuarioAndClaveAndTipoUsuario(usuario, clave, tipoUsuario).orElse(null);
	}
	
	// Método para listar los usuarios según su tipo
	public List<Usuario> listarPorTipo(TipoUsuario tipoUsuario) {
		return repo.findByTipoUsuario(tipoUsuario).orElse(null);
	}
	
	// Método para listar los usuarios según su tipo y semejanza a nombre, paterno o materno
	public List<Usuario> listarPorNombres(String nombre, String paterno, String materno) {
		return repo.findByNombreLikeOrPaternoLikeOrMaternoLike
				(nombre, paterno, materno).orElse(null);
	}
	
	// Método para listar los usuarios según su aula
	public List<Usuario> listarPorAula(Aula aula) {
		return repo.findByAula(aula).orElse(null);
	}
	
	// Método para crear un usuario
	public void registrar(Usuario bean) {
		repo.save(bean);
	}
	
	// Método para actualizar un usuario
	public void actualizar(Usuario bean) {
		repo.save(bean);
	}
	
	// Método para eliminar un usuario según su id
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
