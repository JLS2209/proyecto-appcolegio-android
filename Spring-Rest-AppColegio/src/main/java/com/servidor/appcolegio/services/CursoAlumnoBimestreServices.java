package com.servidor.appcolegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.appcolegio.entity.Bimestre;
import com.servidor.appcolegio.entity.CursoAlumnoBimestre;
import com.servidor.appcolegio.entity.CursoAula;
import com.servidor.appcolegio.entity.Usuario;
import com.servidor.appcolegio.repository.CursoAlumnoBimestreRepository;

@Service
public class CursoAlumnoBimestreServices {
	// Los servicios trabajan con los repositorios
	@Autowired										// Inyección de dependencia
	private CursoAlumnoBimestreRepository repo;
	
	// Método para listar los CAB según el alumno
	public List<CursoAlumnoBimestre> listarPorAlumno(Usuario alumno) {
		return repo.findByAlumno(alumno).orElse(null);
	}
	
	// Método para listar los CAB según el alumno y bimestre
	public List<CursoAlumnoBimestre> listarPorAlumnoYBimestre(Usuario alumno, Bimestre bimestre) {
		return repo.findByAlumnoAndBimestre(alumno, bimestre).orElse(null);
	}
	
	// Método para buscar un CAB por su Id
	public CursoAlumnoBimestre buscarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	// Método para buscar un CAB por la combinación CursoAula - Alumno - Bimestre
	public CursoAlumnoBimestre buscarPorCAB(CursoAula cursoAula, Usuario alumno, Bimestre bimestre) {
		return repo.findByCursoAulaAndAlumnoAndBimestre(cursoAula, alumno, bimestre).orElse(null);
	}
	
	// Método para crear un CAB
	public void registrar(CursoAlumnoBimestre bean) {
		repo.save(bean);
	}
	
	// Método para actualizar un CAB
	public void actualizar(CursoAlumnoBimestre bean) {
		repo.save(bean);
	}
	
	// Método para eliminar un CAB según su id
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
