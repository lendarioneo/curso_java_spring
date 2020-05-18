package br.com.lendarioneo.curso_java_spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    /**
     * Utilizado para definir que uma associação é de muitos para muitos.
     *
     *  No JoinTable:
     * - Cria um mapeamento entre a classe atual e a classe usada como atributo, para que gere uma tabela MxM;
     * - name = Nome da tabela MxM;
     * - JoinColumns refere-se as colunas da entidade de dominio que serão usadas no join;
     * - JoinColumn especifica o nome da coluna na tabela MxM que vai guardar a referencia para o dono da relação;
     * - InverseJoinColumns especifica o nome da coluna na tabela MxM que vai guardar a referencia para a outra tabela;
     * */
    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();


    /**
     * Utilizado para definir a relação de um para muitos;
     * mappedBy é o parametro que informa qual atributo, da classe X relacionada, guarda a chave primária.
     */
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> orderItems = new HashSet<>();

    public Product(Long id, String name, String description, Double price, String imgURL) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<Order> getorders() {
        Set<Order> orders = new HashSet<>();
        for (OrderItem item : orderItems) {
            orders.add(item.getOrder());
        }
        return orders;
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
                Objects.equals(getImgURL(), product.getImgURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getImgURL());
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
