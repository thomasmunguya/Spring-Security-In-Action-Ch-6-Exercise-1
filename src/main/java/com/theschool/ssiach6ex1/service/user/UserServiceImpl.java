package com.theschool.ssiach6ex1.service.user;

import com.theschool.ssiach6ex1.model.user.SecurityUser;
import com.theschool.ssiach6ex1.model.user.User;
import com.theschool.ssiach6ex1.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.function.Supplier;

/**
 * An implementation of the {@code UserService}.
 *
 * @author Thomas Munguya
 */
public class UserServiceImpl implements UserService {

    /**
     * Defines the user repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Defines the password encoder.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Authentication failed.");
        User user = userRepository.findById(username).orElseThrow(s);
        return new SecurityUser(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createUser(User user) {
        if(user == null) {
            throw new IllegalArgumentException("null user provided.");
        }
        user.setPassword("{bycrypt}" + passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(User user) {
        userRepository.findById(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist."));
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUserByUsername(String username) {
        userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist."));
        userRepository.deleteById(username);
    }
}
