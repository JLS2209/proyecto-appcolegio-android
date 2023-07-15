package com.servidor.appcolegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.appcolegio.entity.CursoAlumnoBimestre;
import com.servidor.appcolegio.entity.Nota;
import com.servidor.appcolegio.repository.NotaRepository;

@Service
public class NotaServices {
	// Los servicios trabajan con los repositorios
	@Autowired										// Inyección de dependencia
	private NotaRepository repo;
	
	// Método para listar las notas según su CAB
	public List<Nota> listarPorCAB(CursoAlumnoBimestre cab) {
		return repo.findByCursoAlumnoBimestre(cab).orElse(null);
	}
	
	
	// Método para crear un aula
	public void registrar(Nota bean) {
		repo.save(bean);
	}
	
	// Método para actualizar un aula
	public void actualizar(Nota bean) {
		repo.save(bean);
	}
	
	// Método para eliminar un aula según su id
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
}
