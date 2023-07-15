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

import com.servidor.appcolegio.entity.CursoAlumnoBimestre;
import com.servidor.appcolegio.entity.Nota;
import com.servidor.appcolegio.services.NotaServices;



@RestController 
@RequestMapping("/nota")
public class NotaController {
	@Autowired
	private NotaServices notaServicio;
	
	
	// Ruta que retorna un JSON de las notas que pertenecen a cierto CAB
	@GetMapping("/listarCAB/{idCAB}")
	public List<Nota> listarPorCAB(@PathVariable("idCAB") Integer idCAB) {
		CursoAlumnoBimestre bean = new CursoAlumnoBimestre();
		bean.setIdCursoAlumnoBimestre(idCAB);
		return notaServicio.listarPorCAB(bean);
	}
	
	
	@PostMapping("/crear")
	public void registrar(@RequestBody Nota bean) {
		notaServicio.registrar(bean);
	}

	@PutMapping("/actualizar")
	   public void actualizar(@RequestBody Nota bean) {
		notaServicio.actualizar(bean);
	}

	@DeleteMapping("/eliminar/{id}")
	   public void eliminar(@PathVariable("id") Integer id) {
		notaServicio.eliminar(id);
	}

}
