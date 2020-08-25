package com.poc.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import com.poc.authserver.usuario.UsuarioService;

@Configuration
@EnableAuthorizationServer
public class AuthConfig extends AuthorizationServerConfigurerAdapter{

  @Autowired
  private BCryptPasswordEncoder encoder;
  
  @Autowired
  private AuthenticationManager manager;
  
  @Autowired
  private UsuarioService usuarioService;
  
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
     .withClient("lanche")
     .secret(encoder.encode("lanche123"))
     .authorizedGrantTypes("check_token", "password", "refresh_token")
     .scopes("all")
     .and()
     .withClient("zuul")
     .secret(encoder.encode("zuul123"))
     .authorizedGrantTypes("check_token", "password", "refresh_token")
     .scopes("all")
      .and()
      .withClient("api")
      .secret(encoder.encode("api123"))
      .authorizedGrantTypes("check_token", "client_credentials", "refresh_token")
      .scopes("all");
  }
  
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.authenticationManager(manager).userDetailsService(usuarioService);
  }
}
