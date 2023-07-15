package com.servidor.appcolegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.appcolegio.entity.CursoID;
import com.servidor.appcolegio.repository.CursoRepository;



@Service
public class CursoServices {
	// Los servicios trabajan con los repositorios
	@Autowired										// Inyección de dependencia
	private CursoRepository repo;
	
	// Método para listar todos los grados
	public List<CursoID> listarTodos() {
		return repo.findAll();
	}
}
