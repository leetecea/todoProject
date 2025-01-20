package br.ufba.tomorrow.todoProject.domain.services;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import br.ufba.tomorrow.todoProject.repository.UsuarioRepository;

public class UserDetailsServiceImpl {
	private final UsuarioRepository repository;
	
	public UserDetailsServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	/*
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario currentUser = repository.findByEmail(email);
		if(currentUser != null) {
			
		}
	}
	*/
}
