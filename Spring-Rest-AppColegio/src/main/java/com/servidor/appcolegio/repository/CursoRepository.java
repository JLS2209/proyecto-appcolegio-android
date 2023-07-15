package com.servidor.appcolegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servidor.appcolegio.entity.CursoID;

public interface CursoRepository  extends JpaRepository<CursoID, Integer>{

}
