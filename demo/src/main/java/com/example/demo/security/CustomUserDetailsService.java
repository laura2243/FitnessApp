package com.example.demo.security;

import com.example.demo.entity.RoleEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

/**
 * Class for retrieving users from the database in the form of user details
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method for returning a user from the Users table based on its username
     * if found a UserDetails is returned with the details of the user from the database
     * else UsernameNotFoundException exception thrown
     * @param username
     * @return User
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found."));
        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
    }

    /**
     * Method that converts a Role object into a GrantedAuthority object
     * @param roleEntity
     * @return GrantedAuthority
     */
    private Collection<GrantedAuthority> mapRolesToAuthorities(RoleEntity roleEntity) {
        return Collections.singleton(new SimpleGrantedAuthority(roleEntity.getName()));
    }
}
