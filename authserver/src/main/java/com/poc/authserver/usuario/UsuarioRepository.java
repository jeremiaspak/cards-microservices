package com.poc.authserver.usuario;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
  public Optional<Usuario> findByNome(String nome);
}
