package com.servidor.appcolegio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servidor.appcolegio.entity.Aula;
import com.servidor.appcolegio.entity.TipoUsuario;
import com.servidor.appcolegio.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	// Encuentra un usuario con las credenciales de login: usuario, clave y tipo de usuario
	Optional<Usuario> findByUsuarioAndClaveAndTipoUsuario 
		(String usuario, String clave, TipoUsuario tipoUsuario);
	
	// Devuelve la lista de usuarios de cierto tipo
	Optional<List<Usuario>> findByTipoUsuario (TipoUsuario tipoUsuario);
	
	// Devuelve la lista de usuarios de cierto tipo 
	// y cuyos nombre, paterno o materno se parezcan al argumento ingresado
	Optional<List<Usuario>> findByNombreLikeOrPaternoLikeOrMaternoLike
		(String nombre, String paterno, String materno);
	
	// Devuelve la lista de usuarios en cierta aula
	Optional<List<Usuario>> findByAula (Aula aula);
	

}
