package br.com.lendarioneo.curso_java_spring.services;

import br.com.lendarioneo.curso_java_spring.entities.User;
import br.com.lendarioneo.curso_java_spring.repositories.UserRepository;
import br.com.lendarioneo.curso_java_spring.services.exceptions.DatabaseException;
import br.com.lendarioneo.curso_java_spring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public User findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return this.repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }

        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }

        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        try {
            User userTmp = repository.getOne(id);
            userTmp.setName(user.getName())
                    .setEmail(user.getEmail())
                    .setPassword(user.getPassword())
                    .setPhone(user.getPhone());
            return repository.save(userTmp);
        }

        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }
}
