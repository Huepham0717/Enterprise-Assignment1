package com.example.demo.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "cart", uniqueConstraints = {@UniqueConstraint(columnNames = {"cartId"})})
public class Cart {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id")
    private User user;
    private float amount;
//    @OneToMany(mappedBy = "cart")
//    private List<CartItem> cartItemList;

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
