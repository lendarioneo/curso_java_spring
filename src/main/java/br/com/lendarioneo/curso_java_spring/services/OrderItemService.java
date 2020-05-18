package br.com.lendarioneo.curso_java_spring.services;

import br.com.lendarioneo.curso_java_spring.entities.OrderItem;
import br.com.lendarioneo.curso_java_spring.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> findAll() {
        return this.repository.findAll();
    }

    public OrderItem findById(Long id) {
        return this.repository.findById(id).get();
    }
}
