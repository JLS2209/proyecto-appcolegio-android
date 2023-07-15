package com.servidor.appcolegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.appcolegio.entity.Aula;
import com.servidor.appcolegio.entity.Grado;
import com.servidor.appcolegio.repository.AulaRepository;

@Service
public class AulaServices {
	// Los servicios trabajan con los repositorios
	@Autowired										// Inyección de dependencia
	private AulaRepository repo;
	
	// Método para listar todas las aulas
	public List<Aula> listarTodos() {
		return repo.findAll();
	}
	
	// Método para listar las aulas según su grado
	public List<Aula> listarPorGrado(Grado grado) {
		return repo.findByGrado(grado).orElse(null);
	}
	
	// Método para buscar un Aula por su Id
	public Aula buscarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	// Método para crear un aula
	public void registrar(Aula bean) {
		repo.save(bean);
	}
	
	// Método para actualizar un aula
	public void actualizar(Aula bean) {
		repo.save(bean);
	}
	
	// Método para eliminar un aula según su id
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
}
