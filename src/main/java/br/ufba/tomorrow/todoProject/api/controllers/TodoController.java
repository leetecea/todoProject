package br.ufba.tomorrow.todoProject.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.domain.services.TodoService;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TodoController {
	
	private final TodoService service;
	public TodoController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<TodoDTO>> listar(){
		return null;
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<TodoDTO>> listarPorUsuario(@PathVariable long userId){
		return new ResponseEntity<List<TodoDTO>>(service.listarTarefasPorUsuario(userId), HttpStatus.OK);
	
	}
	
	@GetMapping("/{userId}/{status}")
	public ResponseEntity<List<TodoDTO>> listarPorUsuarioEStatus(@PathVariable long userId, @PathVariable Estado status ){
		return new ResponseEntity<List<TodoDTO>>(service.listarTarefasPorUsuarioComEstado(userId, status), HttpStatus.OK);
	
	}
	
	@PostMapping
	public ResponseEntity<TodoDTO> criar(@RequestBody TodoCreateDTO tarefa){
		return new ResponseEntity<TodoDTO>(service.criar(tarefa), HttpStatus.CREATED);
	}
	

	@PutMapping
	public ResponseEntity<TodoDTO> editar(@RequestBody TodoUpdateDTO tarefa) throws Exception{
		return new ResponseEntity<TodoDTO>(service.editar(tarefa), HttpStatus.OK);
	}

	
	@DeleteMapping("/{tarefaId}")
	public ResponseEntity<TodoDTO> removerUsuario(@PathVariable Long tarefaId){
		return null;
	}
	
	@PatchMapping
	public ResponseEntity<TodoDTO> concluir(){
		return null;
	}
}
