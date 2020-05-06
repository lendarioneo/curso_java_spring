package br.com.lendarioneo.curso_java_spring.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table (name = "tb_order")
public class Order implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    private Integer orderStatus;

    public Order() {
    }

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
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
