package br.com.lendarioneo.curso_java_spring.repositories;

import br.com.lendarioneo.curso_java_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
