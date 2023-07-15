package com.servidor.appcolegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.appcolegio.entity.Grado;
import com.servidor.appcolegio.services.GradoServices;

@RestController 
@RequestMapping("/grado")
public class GradoController {
	@Autowired
	private GradoServices gradoServicio;
	
	// Ruta que retorna un JSON de todos los grados
	@GetMapping("/listarTodo")
	public List<Grado> listarTodo() {
		return gradoServicio.listarTodos();
	}
}
