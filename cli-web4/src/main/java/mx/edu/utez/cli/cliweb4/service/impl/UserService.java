/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import mx.edu.utez.cli.cliweb4.entity.UserRole;
import mx.edu.utez.cli.cliweb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
@Transactional
public class UserService implements UserDetailsService{
 
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        mx.edu.utez.cli.cliweb4.entity.User user = userRepository.findByUsername(username);
        if (user != null) {
            return buildUser(user, buildAuthorities(user.getUserRole()));
        } else {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }
    }

    private User buildUser(mx.edu.utez.cli.cliweb4.entity.User user, List<GrantedAuthority> authorities) {
        boolean enabled = false;

        if (user.getEnabled() == 1) {
            enabled = true;
        }

        return new User(user.getUsername(), user.getPassword(), enabled, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for (UserRole userRole : userRoles) {
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);

    }
}
