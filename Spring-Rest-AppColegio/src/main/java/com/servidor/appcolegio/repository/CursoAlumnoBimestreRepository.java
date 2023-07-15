package com.servidor.appcolegio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servidor.appcolegio.entity.Bimestre;
import com.servidor.appcolegio.entity.CursoAlumnoBimestre;
import com.servidor.appcolegio.entity.CursoAula;
import com.servidor.appcolegio.entity.Usuario;

public interface CursoAlumnoBimestreRepository extends JpaRepository<CursoAlumnoBimestre, Integer>{
	
	// Devuelve la lista de CAB de cierto alumno
	Optional<List<CursoAlumnoBimestre>> findByAlumno (Usuario alumno);
	
	// Devuelve la lista de CAB de cierto alumno y bimestre
	Optional<List<CursoAlumnoBimestre>> findByAlumnoAndBimestre (Usuario alumno, Bimestre bimestre);
	
	// Devuelve el único CAB de la combinación CursoAula - Alumno - Bimestre
	Optional<CursoAlumnoBimestre> findByCursoAulaAndAlumnoAndBimestre (CursoAula cursoAula, Usuario alumno, Bimestre bimestre);

}
