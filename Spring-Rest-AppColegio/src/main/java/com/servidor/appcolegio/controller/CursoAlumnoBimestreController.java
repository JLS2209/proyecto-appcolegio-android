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
import com.servidor.appcolegio.entity.CursoAlumnoBimestre;
import com.servidor.appcolegio.entity.CursoAula;
import com.servidor.appcolegio.entity.Usuario;
import com.servidor.appcolegio.services.CursoAlumnoBimestreServices;

@RestController 
@RequestMapping("/cursoAlumnoBimestre")
public class CursoAlumnoBimestreController {
	@Autowired
	private CursoAlumnoBimestreServices cabServicio;
	
	// Ruta que retorna un JSON con los CAB según alumno
	@GetMapping("/listarAlumno/{idAlumno}")
	public List<CursoAlumnoBimestre> listarPorAlumno(@PathVariable("idAlumno") Integer idAlumno) {
		Usuario beanAlumno = new Usuario();
		beanAlumno.setIdUsuario(idAlumno);
		return cabServicio.listarPorAlumno(beanAlumno);
	}
	
	// Ruta que retorna un JSON con los CAB según alumno y bimestre
	@GetMapping("/listarAlumnoBimestre/{idAlumno}/{idBimestre}")
	public List<CursoAlumnoBimestre> listarPorAlumnoYBimestre(
			@PathVariable("idAlumno") Integer idAlumno,
			@PathVariable("idBimestre") Integer idBimestre) {
		
		Usuario beanAlumno = new Usuario();
		beanAlumno.setIdUsuario(idAlumno);
		
		Bimestre beanBimestre = new Bimestre();
		beanBimestre.setIdBimestre(idBimestre);
		
		return cabServicio.listarPorAlumnoYBimestre(beanAlumno, beanBimestre);
	}
	
	
	// Ruta que retorna un JSON de un CAB según su ID
	@GetMapping("/buscarId/{id}")
	public CursoAlumnoBimestre buscarPorId(@PathVariable("id") Integer id) {
		return cabServicio.buscarPorId(id);
	}
	
	// Ruta que retorna un JSON de un CAB según la combinación CursoAula - Alumno - Bimestre
	@GetMapping("/buscarCAB/{idCursoAula}/{idAlumno}/{idBimestre}")
	public CursoAlumnoBimestre buscarCAB(
			@PathVariable("idCursoAula") Integer idCursoAula,
			@PathVariable("idAlumno") Integer idAlumno, 
			@PathVariable("idBimestre") Integer idBimestre) {
		
		CursoAula beanCurso = new CursoAula();
		beanCurso.setIdCursoAula(idCursoAula);
		
		Usuario beanAlumno = new Usuario();
		beanAlumno.setIdUsuario(idAlumno);
		
		Bimestre beanBimestre = new Bimestre();
		beanBimestre.setIdBimestre(idBimestre);
		
		return cabServicio.buscarPorCAB(beanCurso, beanAlumno, beanBimestre);
	}
	
	@PostMapping("/crear")
	public void registrar(@RequestBody CursoAlumnoBimestre bean) {
		cabServicio.registrar(bean);
	}

	@PutMapping("/actualizar")
	   public void actualizar(@RequestBody CursoAlumnoBimestre bean) {
		cabServicio.actualizar(bean);
	}

	@DeleteMapping("/eliminar/{id}")
	   public void eliminar(@PathVariable("id") Integer id) {
		cabServicio.eliminar(id);
	}

}
