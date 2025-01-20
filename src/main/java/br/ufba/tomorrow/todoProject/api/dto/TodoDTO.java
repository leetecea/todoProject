package br.ufba.tomorrow.todoProject.api.dto;

import java.time.LocalDate;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.domain.entities.Todo;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoDTO {
	private long id;
	private Long usuarioId;
	private String item;
	private LocalDate prazo;
	private Estado status;
	
	public TodoDTO() {};
	public TodoDTO(Todo todo) {
		this.id = todo.getId();
		this.usuarioId = todo.getUsuario().getId();
		this.item = todo.getItem();
		this.prazo = todo.getPrazo();
		this.status = todo.getStatus();
	}

}
