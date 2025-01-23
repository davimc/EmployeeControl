package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.entities.User;
import br.com.grupotsm.EmployeeControl.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(User.class);
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usr = repository.findByCpf(username);
        if(usr.isPresent()) {
            logger.info("User found: " + username);
            return usr.get();
        }
        logger.error("CPF not found: " + username);
        throw new UsernameNotFoundException("CPF not found: " + username);
    }
}
