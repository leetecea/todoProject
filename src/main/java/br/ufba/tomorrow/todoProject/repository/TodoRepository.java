package br.ufba.tomorrow.todoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.domain.entities.Todo;
import br.ufba.tomorrow.todoProject.domain.entities.Usuario;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
	public Todo save(Todo t);
	public List<Todo> findByUsuario(Usuario usuario);
	public List<Todo> findByUsuarioAndStatus(Usuario usuario, Estado status);
}
