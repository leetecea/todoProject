package br.ufba.tomorrow.todoProject.api.dto;
import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDTO {
    Long id;
    String email;
    
    public UsuarioDTO() {}
    public UsuarioDTO(Usuario usuario) {
    	this.id = usuario.getId();
    	this.email = usuario.getEmail();
    }
}
