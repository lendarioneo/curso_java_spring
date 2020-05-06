package br.com.lendarioneo.curso_java_spring.services;

import br.com.lendarioneo.curso_java_spring.entities.Product;
import br.com.lendarioneo.curso_java_spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return this.repository.findAll();
    }

    public Product findById(Long id) {
        return this.repository.findById(id).get();
    }

}
