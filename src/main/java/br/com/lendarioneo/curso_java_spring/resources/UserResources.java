package br.com.lendarioneo.curso_java_spring.resources;

import br.com.lendarioneo.curso_java_spring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Weskley", "weskley@gmail.com", "999999", "12345");
        return ResponseEntity.ok(u);
    }
}
