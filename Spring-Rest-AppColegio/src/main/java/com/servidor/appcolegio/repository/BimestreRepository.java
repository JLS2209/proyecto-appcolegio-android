package com.servidor.appcolegio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servidor.appcolegio.entity.Bimestre;

public interface BimestreRepository  extends JpaRepository<Bimestre, Integer>{

	// Devuelve la lista de bimestres de cierto año
	Optional<List<Bimestre>> findByAnio (int anio);
}
