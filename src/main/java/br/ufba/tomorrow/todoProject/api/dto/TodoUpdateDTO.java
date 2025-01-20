package br.ufba.tomorrow.todoProject.api.dto;

import java.time.LocalDate;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoUpdateDTO {
	private long id;
	private String item;
	private LocalDate prazo;
	private Estado status;
	private LocalDate conclusao;

}
