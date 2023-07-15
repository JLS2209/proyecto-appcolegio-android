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
import com.servidor.appcolegio.entity.TipoUsuario;
import com.servidor.appcolegio.entity.Usuario;
import com.servidor.appcolegio.services.UsuarioServices;

@RestController 
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioServices usuarioServicio;
	
	// Ruta que retorna un JSON de todos los usuarios
	@GetMapping("/listarTodo")
	public List<Usuario> listarTodo() {
		return usuarioServicio.listarTodos();
	}
	
	// Ruta que retorna un JSON de un usuario según su ID
	@GetMapping("/buscarId/{id}")
	public Usuario buscarPorId(@PathVariable("id") Integer id) {
		return usuarioServicio.buscarPorId(id);
	}
	
	// Ruta que retorna un JSON de un usuario según sus credenciales de login
	@GetMapping("/buscarLogin/{usuario}/{clave}/{idTipo}")
	public Usuario buscarPorLogin(@PathVariable("usuario") String usuario, 
			@PathVariable("clave") String clave, @PathVariable("idTipo") Integer idTipoUsuario) {
		TipoUsuario beanTipo = new TipoUsuario();
		beanTipo.setIdTipoUsuario(idTipoUsuario);
		return usuarioServicio.buscarPorLogin(usuario, clave, beanTipo);
	}
	
	// Ruta que retorna un JSON con los usuarios según su tipo
	@GetMapping("/listarTipoUsuario/{idTipo}")
	public List<Usuario> listarPorTipo(@PathVariable("idTipo") Integer idTipoUsuario) {
		TipoUsuario beanTipo = new TipoUsuario();
		beanTipo.setIdTipoUsuario(idTipoUsuario);
		return usuarioServicio.listarPorTipo(beanTipo);
	}
	
	// Ruta que retorna un JSON con los usuarios según su tipo y por semejanza a sus nombres
	@GetMapping("/listarNombres/{idTipo}/{nombres}")
	public List<Usuario> listarPorNombres(@PathVariable("nombres") String nombres, 
			@PathVariable("idTipo") Integer idTipoUsuario) {
		nombres = nombres + "%";
		List<Usuario> listaUsuarios = usuarioServicio.listarPorNombres(nombres, nombres, nombres);
		listaUsuarios.removeIf(t -> t.getTipoUsuario().getIdTipoUsuario() != idTipoUsuario);
		return listaUsuarios;
	}
	
	// Ruta que retorna un JSON con los usuarios según su aula
	@GetMapping("/listarAula/{idAula}")
	public List<Usuario> listarPorAula(@PathVariable("idAula") Integer idAula) {
		Aula beanAula = new Aula();
		beanAula.setIdAula(idAula);
		return usuarioServicio.listarPorAula(beanAula);
	}
	
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Usuario bean) {
		usuarioServicio.registrar(bean);
	}

	@PutMapping("/actualizar")
	   public void actualizar(@RequestBody Usuario bean) {
		usuarioServicio.actualizar(bean);
	}

	@DeleteMapping("/eliminar/{id}")
	   public void eliminar(@PathVariable("id") Integer id) {
		usuarioServicio.eliminar(id);
	}	

}
