package br.com.lendarioneo.curso_java_spring.repository;

import br.com.lendarioneo.curso_java_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
