package com.poc.authserver.usuario;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @GetMapping("/me")
  public Map<String, Object> validar(Principal principal) {
    Optional<Usuario> optional = usuarioRepository.findByNome(principal.getName());

    Map<String, Object> map = new HashMap<>();
    map.put("name", principal.getName());
    if(optional.isPresent()) {
      map.put("id", optional.get().getId());
    }else{
      map.put("id", 0);
    }
    return map;
  }
}
