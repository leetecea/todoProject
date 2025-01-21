package br.ufba.tomorrow.todoProject.domain.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.todoProject.api.dto.UsuarioCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.UsuarioDTO;
import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import br.ufba.tomorrow.todoProject.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository repo;
	private final PasswordEncoder passwordEncoder;
	public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}
	
	public UsuarioDTO criar(UsuarioCreateDTO dto) throws DataIntegrityViolationException {
		Usuario usuario = repo.findByEmail(dto.getEmail());
		if(usuario != null) throw new DataIntegrityViolationException("Já existe usuário cadastrado com este email!");
		
		dto.setSenha(passwordEncoder.encode(dto.getSenha()));
		return new UsuarioDTO(repo.save(new Usuario(dto)));
	}
}
