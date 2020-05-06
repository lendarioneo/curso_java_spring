package br.com.lendarioneo.curso_java_spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@ManyToMany (mappedBy = "categories")
    @Transient
    private Set<Product> products = new HashSet<>();

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(getId(), category.getId()) &&
                Objects.equals(getName(), category.getName()) &&
                Objects.equals(getProducts(), category.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProducts());
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
