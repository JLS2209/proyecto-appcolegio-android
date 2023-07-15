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
import com.servidor.appcolegio.entity.CursoAula;
import com.servidor.appcolegio.entity.Usuario;
import com.servidor.appcolegio.services.CursoAulaServices;

@RestController 
@RequestMapping("/cursoAula")
public class CursoAulaController {
	@Autowired
	private CursoAulaServices cursoAulaServicio;
	
	// Ruta que retorna un JSON con los CursoAula según docente
	@GetMapping("/listarDocente/{idDocente}")
	public List<CursoAula> listarPorDocente(@PathVariable("idDocente") Integer idDocente) {
		Usuario beanDocente = new Usuario();
		beanDocente.setIdUsuario(idDocente);
		return cursoAulaServicio.listarPorDocente(beanDocente);
	}
	
	// Ruta que retorna un JSON con los CursoAula según aula
	@GetMapping("/listarAula/{idAula}")
	public List<CursoAula> listarPorAula(@PathVariable("idAula") Integer idAula) {
		Aula beanAula = new Aula();
		beanAula.setIdAula(idAula);
		return cursoAulaServicio.listarPorAula(beanAula);
	}
	
	// Ruta que retorna un JSON de un Aula según su ID
	@GetMapping("/buscarId/{id}")
	public CursoAula buscarPorId(@PathVariable("id") Integer id) {
		return cursoAulaServicio.buscarPorId(id);
	}
	
	@PostMapping("/adicionar")
	public void registrar(@RequestBody CursoAula bean) {
		cursoAulaServicio.registrar(bean);
	}

	@PutMapping("/actualizar")
	   public void actualizar(@RequestBody CursoAula bean) {
		cursoAulaServicio.actualizar(bean);
	}

	@DeleteMapping("/eliminar/{id}")
	   public void eliminar(@PathVariable("id") Integer id) {
		cursoAulaServicio.eliminar(id);
	}

}
