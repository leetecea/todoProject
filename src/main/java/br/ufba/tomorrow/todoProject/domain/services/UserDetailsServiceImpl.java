package br.ufba.tomorrow.todoProject.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import br.ufba.tomorrow.todoProject.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private final UsuarioRepository repository;
	
	public UserDetailsServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario currentUser = repository.findByEmail(email);
//        System.out.print(email);
//        System.out.print(currentUser.getSenha());
        if (currentUser != null) {
            return new User(
                    email,
                    currentUser.getSenha(),
                    true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER")
            );
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }
    }
}
