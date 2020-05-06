package br.com.lendarioneo.curso_java_spring.services;

import br.com.lendarioneo.curso_java_spring.entities.Order;
import br.com.lendarioneo.curso_java_spring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return this.orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> optionalUser = this.orderRepository.findById(id);
        return optionalUser.get();
    }
}
