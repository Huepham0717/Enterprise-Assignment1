package com.example.demo.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "cart",uniqueConstraints={@UniqueConstraint(columnNames ={"cartId"})})
public class Cart {
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cartDetail_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private Long cartId;
    @ManyToOne
    @JoinColumn(nullable = false,name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User user;
    private int quantity;
    private float amount;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", product=" + product +
                ", user=" + user +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }

    public Cart(Long cartId, Product product, User user, int quantity, float amount) {
        this.cartId = cartId;
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.amount = amount;
    }
}
