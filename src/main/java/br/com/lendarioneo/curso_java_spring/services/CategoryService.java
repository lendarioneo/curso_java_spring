package br.com.lendarioneo.curso_java_spring.services;

import br.com.lendarioneo.curso_java_spring.entities.Category;
import br.com.lendarioneo.curso_java_spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return this.repository.findAll();
    }

    public Category findById(Long id) {
        return this.repository.findById(id).get();
    }

}
