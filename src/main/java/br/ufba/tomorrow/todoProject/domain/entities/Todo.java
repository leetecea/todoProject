package br.ufba.tomorrow.todoProject.domain.entities;

import java.time.LocalDate;

import br.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pb_todos")
@Getter @Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	private String item;
	
	private LocalDate prazo;
	
	private Estado status;
	
	private LocalDate conclusao;	
	
	public Todo() {};
	public Todo(TodoCreateDTO todo) {
		setUsuario(new Usuario(todo.getIdUsu()));
		setStatus(todo.getStatus());
		setItem(todo.getItem());
		setPrazo(todo.getPrazo());
	}
	
	public Todo(TodoUpdateDTO dto) {
		this.id = dto.getId();
		this.item = dto.getItem();
		this.prazo = dto.getPrazo();
		this.status = dto.getStatus();
		this.conclusao = dto.getConclusao();		
	}


}
