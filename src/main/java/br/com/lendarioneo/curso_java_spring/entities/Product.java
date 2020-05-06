package br.com.lendarioneo.curso_java_spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imgURL;

    //@ManyToMany(mappedBy = "products")
    @Transient
    private Set<Category> categories = new HashSet<>();

    public Product(Long id, String name, String description, Double price, String imgURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
    }

    public Product() {
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getImgURL() {
        return imgURL;
    }

    public Product setImgURL(String imgURL) {
        this.imgURL = imgURL;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getImgURL(), product.getImgURL()) &&
                Objects.equals(getCategories(), product.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getImgURL(), getCategories());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgURL='" + imgURL + '\'' +
                ", categories=" + categories +
                '}';
    }
}
