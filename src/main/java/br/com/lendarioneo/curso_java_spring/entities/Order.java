package br.com.lendarioneo.curso_java_spring.entities;


import br.com.lendarioneo.curso_java_spring.entities.enuns.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "tb_order")
public class Order implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany (mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne (mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        super();
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.orderStatus = orderStatus.getCode();
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getMoment() {
        return moment;
    }

    public Order setMoment(Instant moment) {
        this.moment = moment;
        return this;
    }

    public User getClient() {
        return client;
    }

    public Order setClient(User client) {
        this.client = client;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(this.orderStatus);
    }

    public Order setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
        return this;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal(){
        double sum = 0;
        for (OrderItem item: this.items){
            sum += item.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId()) &&
                Objects.equals(getMoment(), order.getMoment()) &&
                Objects.equals(getClient(), order.getClient()) &&
                getOrderStatus() == order.getOrderStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMoment(), getClient(), getOrderStatus());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", client=" + client +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
