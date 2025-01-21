package br.ufba.tomorrow.todoProject.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.domain.entities.Todo;
import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import br.ufba.tomorrow.todoProject.repository.TodoRepository;

@Service
public class TodoService {
	
	private final TodoRepository repository;
	public TodoService(final TodoRepository repository) {
		this.repository = repository;
	}
	
	public TodoDTO criar(TodoCreateDTO todo) {
		return new TodoDTO(repository.save(new Todo(todo)));
	}

	public List<TodoDTO> listarTarefasPorUsuario(long userId) {
		return repository.findByUsuario(new Usuario(userId))
				.stream()
				.map(TodoDTO::new)
				.collect(Collectors.toList());
	}
	
	public List<TodoDTO> listarTarefasPorUsuarioComEstado(long userId, Estado status){
		return repository.findByUsuarioAndStatus(new Usuario(userId), status)
				.stream()
				.map(TodoDTO::new)
				.collect(Collectors.toList());
	}
	
	public TodoDTO editar(TodoUpdateDTO dto) throws Exception {
		Todo existe = repository.findById(dto.getId()).get();
		if(existe != null) {
			Todo inserir = new Todo(dto);
			inserir.setUsuario(existe.getUsuario());
			return new TodoDTO(repository.save(inserir));
		}
		else throw new Exception("Objeto não encontrado com id:" + dto.getId());
	}

	public TodoDTO remover(Long tarefaId) throws Exception {
	    Todo tarefa = repository.findById(tarefaId)
	            .orElseThrow(() -> new Exception("Tarefa não encontrada com id: " + tarefaId));
	    repository.delete(tarefa);
	    return new TodoDTO(tarefa); 
	}
	
	public TodoDTO concluir(Long tarefaId) throws Exception {
	    Todo tarefa = repository.findById(tarefaId)
	            .orElseThrow(() -> new Exception("Tarefa não encontrada com id: " + tarefaId));
	    tarefa.setStatus(Estado.CONCLUIDO); 
	    return new TodoDTO(repository.save(tarefa));
	}
	
}
