//Acknowledgement:
//
//        "Spring Boot Tutorial | Full Course [2021] [NEW]"
//        https://youtu.be/9SGDpanrc8U
//
//        "Java Tutorial - Complete User Login and Registration Backend + Email Verification"
//        https://youtu.be/QwQuro7ekvc
//
//        "Spring Boot Shopping Cart Tutorial with MySQL Database, Thymeleaf, Bootstrap and jQuery"
//        https://youtu.be/rFSxmKen6aQ
//
//        "Build a Full Stack Reddit Clone with – Spring boot and Angular – Part 3"
//        https://programmingtechie.com/2019/11/08/build-a-full-stack-reddit-clone-with-spring-boot-and-angular-part-3/

package com.example.demo.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// This class is the template from which Spring Boot will construct a database entity named "cart_item".
// "cart_item" stores all the products that is found within each cart in the database.
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "cartItem")
public class CartItem {
    // Telling Spring Boot to treat cartItemId as the primary key
    // and also auto-generate a unique cartItemId for every entry in the table.
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

    // Stores the ID of a product belonging to a particular cart (Foreign Key)
    // One cart_item can have many products
    @ManyToOne
    @JoinColumn(nullable = false,name = "product_id")
    private Product product;

    // Stores the ID of a cart whom a cart_item entry belongs to (Foreign Key)
    // One cart can have many cart_item
    @ManyToOne
    @JoinColumn(nullable = false,name = "cart_id")
    private Cart cart;

    // Quantity colume
    private int quantity;

    // amount = MSRP * quantity
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
