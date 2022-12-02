package com.zapateria;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //Este metodo permite la autenticacion de usuario

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jhohanny")
                .password("{noop}123")
                .roles("ADMIN", "VENDEDOR", "USER")
                .and()
                .withUser("monica")
                .password("{noop}456")
                .roles("VENDEDOR", "USER")
                .and()
                .withUser("nicole")
                .password("{noop}789")
                .roles("USER");
    }

    //permite la autorizacion a los recursos del sitio
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/usuario/nuevo", "usuario/guardar", "/usuario/modificar/**", "/usuario/eliminar/**",
                        "/mujer/nuevo", "mujer/guardar", "/mujer/modificar/**", "/mujer/eliminar/**",
                        "/hombre/nuevo", "hombre/guardar", "/hombre/modificar/**", "/hombre/eliminar/**",
                        "/accesorio/nuevo", "accesorio/guardar", "/accesorio/modificar/**", "/accesorio/eliminar/**",
                        "/usuario/nuevo", "usuario/guardar", "/usuario/modificar/**", "/usuario/eliminar/**")
                .hasRole("ADMIN")
        .antMatchers("/usuario/listado",
                        "/mujer/listado",
                        "/hombre/listado",
                        "/accesorio/listado")
                .hasAnyRole("ADMIN", "VENDEDOR")
        .antMatchers("/")
                .hasAnyRole("ADMIN", "VENDEDOR", "USER")
                .antMatchers("/","/carrito/**")
                .permitAll()
                .antMatchers("/factura/carrito")
                .authenticated()
                .and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errores/403");
    }
}
