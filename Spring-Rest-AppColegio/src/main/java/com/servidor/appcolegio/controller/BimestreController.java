package com.servidor.appcolegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.appcolegio.entity.Bimestre;
import com.servidor.appcolegio.services.BimestreServices;

@RestController 
@RequestMapping("/bimestre")
public class BimestreController {
	@Autowired
	private BimestreServices bimestreServicio;
	
	// Ruta que retorna un JSON de todos los bimestres
	@GetMapping("/listarTodo")
	public List<Bimestre> listarTodo() {
		return bimestreServicio.listarTodos();
	}
	
	// Ruta que retorna un JSON de los bimestres que pertenecen a cierto año
	@GetMapping("/listarAnio/{anio}")
	public List<Bimestre> listarPorAnio(@PathVariable("anio") int anio) {
		return bimestreServicio.listarPorAnio(anio);
	}
	
	// Ruta que retorna un JSON de un Bimestre según su ID
	@GetMapping("/buscarId/{id}")
	public Bimestre buscarPorId(@PathVariable("id") Integer id) {
		return bimestreServicio.buscarPorId(id);
	}
	
	@PostMapping("/crear")
	public void registrar(@RequestBody Bimestre bean) {
		bimestreServicio.registrar(bean);
	}

	@PutMapping("/actualizar")
	   public void actualizar(@RequestBody Bimestre bean) {
		bimestreServicio.actualizar(bean);
	}

	@DeleteMapping("/eliminar/{id}")
	   public void eliminar(@PathVariable("id") Integer id) {
		bimestreServicio.eliminar(id);
	}

}
