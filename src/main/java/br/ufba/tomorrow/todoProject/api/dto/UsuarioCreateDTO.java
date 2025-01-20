package br.ufba.tomorrow.todoProject.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioCreateDTO {
	@NotEmpty
	@Email(message="O email não é válido!")
	String email;
	@Size(min=5, max=20, message="A senha deve ter entre 5 e 20 caracteres")
	String senha;

}
