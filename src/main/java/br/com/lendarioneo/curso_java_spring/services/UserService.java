package br.com.lendarioneo.curso_java_spring.services;

import br.com.lendarioneo.curso_java_spring.entities.User;
import br.com.lendarioneo.curso_java_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> optionalUser = this.userRepository.findById(id);
        return optionalUser.get();
    }
}
