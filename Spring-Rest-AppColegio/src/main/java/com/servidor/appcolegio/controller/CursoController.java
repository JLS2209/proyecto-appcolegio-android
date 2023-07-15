package com.servidor.appcolegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.appcolegio.entity.CursoID;
import com.servidor.appcolegio.services.CursoServices;

@RestController 
@RequestMapping("/curso")
public class CursoController {
	@Autowired
	private CursoServices cursoServicio;
	
	// Ruta que retorna un JSON de todos los grados
	@GetMapping("/listarTodo")
	public List<CursoID> listarTodo() {
		return cursoServicio.listarTodos();
	}
}
