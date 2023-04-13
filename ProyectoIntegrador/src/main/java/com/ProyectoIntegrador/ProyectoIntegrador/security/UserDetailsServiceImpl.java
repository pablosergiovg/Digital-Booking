package com.ProyectoIntegrador.ProyectoIntegrador.security;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Usuario;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email);

        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuario.getRol().getTipo());

        grantList.add(grantedAuthority);

        UserDetails user = null;
        user = (UserDetails) new User(email, usuario.getPassword(), grantList);

        return user;
    }
}
