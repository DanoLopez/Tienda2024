package com.tienda_l.service.impl;

import com.tienda_l.dao.UsuarioDao;
import com.tienda_l.domain.Rol;
import com.tienda_l.domain.Usuario;
import com.tienda_l.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl 
        implements UsuarioDetailsService,
        UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;           
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
       //Se busca el usuario por el username
       Usuario usuario=usuarioDao.findByUsername(username);
       //Se valida si el usuario se encontró...
       if (usuario==null) { //no lo encontró...
           throw new UsernameNotFoundException(username);
       }
        //Si se encontró el usuario... se actualiza la foto de la variable de session
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRutaImagen());
        
        //Se deben recuperar los roles del usuario... y crearlos como roles
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol r : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        //Ya se tiene el arreglo con los roles ya reales...
        return new User(usuario.getUsername(),
                usuario.getPassword(),
                roles);
    }
    
}
