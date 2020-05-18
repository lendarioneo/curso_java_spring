package br.com.lendarioneo.curso_java_spring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public ResourceNotFoundException(Long id){
        super("Resource not found. Id " + id);
    }
}
