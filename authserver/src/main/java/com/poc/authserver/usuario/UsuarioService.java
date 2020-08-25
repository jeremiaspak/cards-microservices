package com.poc.authserver.usuario;

import java.util.Collections;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {
  @Autowired
  private BCryptPasswordEncoder encoder;

  @Autowired
  private UsuarioRepository repository;

  @PostConstruct
  public void popular() {
    Usuario jose = new Usuario();
    jose.setNome("jose");
    jose.setSenha(encoder.encode("123"));
    repository.save(jose);

    Usuario ana = new Usuario();
    ana.setNome("ana");
    ana.setSenha(encoder.encode("123"));
    repository.save(ana);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Usuario> optional = repository.findByNome(username);

    if(!optional.isPresent()) {
      throw new UsernameNotFoundException("Usuário não encontrado");
    }

    Usuario usuario = optional.get();

    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("user");

    return new User(usuario.getNome(), usuario.getSenha(), Collections.singletonList(authority));
  }
}
