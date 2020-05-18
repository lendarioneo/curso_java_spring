package br.com.lendarioneo.curso_java_spring.services;

import br.com.lendarioneo.curso_java_spring.entities.User;
import br.com.lendarioneo.curso_java_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public User findById(Long id) {
        return this.repository.findById(id).get();
    }

    public User insert(User user) {
        return this.repository.save(user);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public User update(Long id, User user){
        User userTmp = repository.getOne(id);
        userTmp.setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setPhone(user.getPhone());
        return repository.save(userTmp);
    }
}
