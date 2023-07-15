package com.servidor.appcolegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.appcolegio.entity.Aula;
import com.servidor.appcolegio.entity.CursoAula;
import com.servidor.appcolegio.entity.Usuario;
import com.servidor.appcolegio.repository.CursoAulaRepository;

@Service
public class CursoAulaServices {
	// Los servicios trabajan con los repositorios
	@Autowired										// Inyección de dependencia
	private CursoAulaRepository repo;
	
	// Método para listar los CursoAula según el docente
	public List<CursoAula> listarPorDocente(Usuario docente) {
		return repo.findByDocente(docente).orElse(null);
	}
	
	// Método para listar los CursoAula según el aula
	public List<CursoAula> listarPorAula(Aula aula) {
		return repo.findByAulaCurso(aula).orElse(null);
	}
	
	// Método para buscar un CursoAula por su Id
	public CursoAula buscarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	// Método para crear un aula
	public void registrar(CursoAula bean) {
		repo.save(bean);
	}
	
	// Método para actualizar un aula
	public void actualizar(CursoAula bean) {
		repo.save(bean);
	}
	
	// Método para eliminar un aula según su id
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
