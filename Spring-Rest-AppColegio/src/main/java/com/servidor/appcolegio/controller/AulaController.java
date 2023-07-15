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

import com.servidor.appcolegio.entity.Aula;
import com.servidor.appcolegio.entity.Grado;
import com.servidor.appcolegio.services.AulaServices;

@RestController 
@RequestMapping("/aula")
public class AulaController {
	@Autowired
	private AulaServices aulaServicio;
	
	// Ruta que retorna un JSON de todas las aulas
	@GetMapping("/listarTodo")
	public List<Aula> listarTodo() {
		return aulaServicio.listarTodos();
	}
	
	// Ruta que retorna un JSON de las aulas que pertenecen a cierto grado
	@GetMapping("/listarGrado/{idGrado}")
	public List<Aula> listarPorGrado(@PathVariable("idGrado") Integer idGrado) {
		Grado beanGrado = new Grado();
		beanGrado.setIdGrado(idGrado);
		return aulaServicio.listarPorGrado(beanGrado);
	}
	
	// Ruta que retorna un JSON de un Aula según su ID
	@GetMapping("/buscarId/{id}")
	public Aula buscarPorId(@PathVariable("id") Integer id) {
		return aulaServicio.buscarPorId(id);
	}
	
	@PostMapping("/crear")
	public void registrar(@RequestBody Aula bean) {
		aulaServicio.registrar(bean);
	}

	@PutMapping("/actualizar")
	   public void actualizar(@RequestBody Aula bean) {
		aulaServicio.actualizar(bean);
	}

	@DeleteMapping("/eliminar/{id}")
	   public void eliminar(@PathVariable("id") Integer id) {
		aulaServicio.eliminar(id);
	}

}
