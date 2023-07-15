package com.servidor.appcolegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.appcolegio.entity.Bimestre;
import com.servidor.appcolegio.repository.BimestreRepository;

@Service
public class BimestreServices {
	// Los servicios trabajan con los repositorios
	@Autowired										// Inyección de dependencia
	private BimestreRepository repo;
	
	// Método para listar todos los bimestres
	public List<Bimestre> listarTodos() {
		return repo.findAll();
	}
	
	// Método para listar los bimestres según año
	public List<Bimestre> listarPorAnio(int anio) {
		return repo.findByAnio(anio).orElse(null);
	}
	
	// Método para buscar un bimestre por su Id
	public Bimestre buscarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	// Método para crear un bimestre
	public void registrar(Bimestre bean) {
		repo.save(bean);
	}
	
	// Método para actualizar un bimestre
	public void actualizar(Bimestre bean) {
		repo.save(bean);
	}
	
	// Método para eliminar un bimestre según su id
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
}
