package br.ufba.tomorrow.todoProject.api.dto;

import java.time.LocalDate;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoCreateDTO {

	private long idUsu;
	private String item;
	private LocalDate prazo;
	private Estado status;

}
