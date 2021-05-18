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
@Table(name = "cartItem")
public class CartItem {
    @SequenceGenerator(
            name = "cartItem_sequence",
            sequenceName = "cartItem_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cartItem_sequence"
    )
    private Long cartItemId;
    @ManyToOne
    @JoinColumn(nullable = false,name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(nullable = false,name = "cart_id")
    private Cart cart;
    private int quantity;
    private float amount;

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartId) {
        this.cartItemId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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
                "cartItemId=" + cartItemId +
                ", product=" + product +
                ", cart=" + cart +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }

    public CartItem(Long cartItemId, Product product, User user, int quantity, float amount) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
        this.amount = amount;
    }
}
