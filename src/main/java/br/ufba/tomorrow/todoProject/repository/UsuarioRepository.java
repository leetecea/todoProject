package br.ufba.tomorrow.todoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario save(Usuario usuario);
	
	public Usuario findByEmail(String email);
	
}
