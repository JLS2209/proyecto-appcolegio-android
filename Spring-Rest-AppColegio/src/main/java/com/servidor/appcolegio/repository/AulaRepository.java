package com.servidor.appcolegio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servidor.appcolegio.entity.Aula;
import com.servidor.appcolegio.entity.Grado;

public interface AulaRepository extends JpaRepository<Aula, Integer>{

	// Devuelve la lista de aulas de cierto grado
	Optional<List<Aula>> findByGrado (Grado grado);

}
