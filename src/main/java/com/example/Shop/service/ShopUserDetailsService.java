package com.example.Shop.service;


import com.example.Shop.entity.UserEntity;
import com.example.Shop.exception.UserAlreadyExistException;
import com.example.Shop.repository.UserRepository;
import com.example.Shop.model.ShopUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ShopUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName).map(ShopUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
    }

    public Iterable<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("Пользователь с таким именем существует");
        }
        return userRepository.save(user);
    }
}