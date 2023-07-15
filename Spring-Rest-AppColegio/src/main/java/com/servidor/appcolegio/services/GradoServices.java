package com.servidor.appcolegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.appcolegio.entity.Grado;
import com.servidor.appcolegio.repository.GradoRepository;

@Service
public class GradoServices {
	// Los servicios trabajan con los repositorios
	@Autowired										// Inyección de dependencia
	private GradoRepository repo;
	
	// Método para listar todos los grados
	public List<Grado> listarTodos() {
		return repo.findAll();
	}
}
