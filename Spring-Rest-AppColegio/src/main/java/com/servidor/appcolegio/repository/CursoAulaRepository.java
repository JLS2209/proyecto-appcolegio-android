package com.servidor.appcolegio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servidor.appcolegio.entity.Aula;
import com.servidor.appcolegio.entity.CursoAula;
import com.servidor.appcolegio.entity.Usuario;

public interface CursoAulaRepository extends JpaRepository<CursoAula, Integer>{
	
	// Devuelve la lista de ClaseAula de cierto docente
	Optional<List<CursoAula>> findByDocente (Usuario docente);
	
	// Devuelve la lista de ClaseAula de cierta aula
	Optional<List<CursoAula>> findByAulaCurso (Aula aulaCurso);

}
