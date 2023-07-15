package com.servidor.appcolegio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servidor.appcolegio.entity.CursoAlumnoBimestre;
import com.servidor.appcolegio.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer>{

	// Devuelve la lista de aulas de cierto grado
	Optional<List<Nota>> findByCursoAlumnoBimestre (CursoAlumnoBimestre cursoAlumnoBimestre);

}
