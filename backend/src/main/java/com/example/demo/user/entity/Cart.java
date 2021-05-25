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
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

// This class is the template from which Spring Boot will construct a database entity named "cart".
// "cart" stores all carts in the database.
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "cart", uniqueConstraints = {@UniqueConstraint(columnNames = {"cartId"})})
public class Cart {
    // Telling Spring Boot to treat cartId as the primary key
    // and also auto-generate a unique cartId for every entry in the table.
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private Long cartId;

    // Date column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    // Stores the ID of the user whom a particular cart belongs to (Foreign Key)
    // One user can have many carts
    @ManyToOne
    @JoinColumn(nullable = false, name = "id")
    private User user;

    // Stores total value of the cart
    private float amount;

    // Stores the status of the cart.
    // If a cart is not paid yet, it is Active (1). Once it is paid, it is no longer Active (0).
    private int isActive;

    public Cart(Long cartId, LocalDate date, User user, float amount, int isActive) {
        this.cartId = cartId;
        this.date = date;
        this.user = user;
        this.amount = amount;
        this.isActive = isActive;
    }


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", date=" + date +
                ", user=" + user +
                ", amount=" + amount +
                ", isActive=" + isActive +
                '}';
    }
}
