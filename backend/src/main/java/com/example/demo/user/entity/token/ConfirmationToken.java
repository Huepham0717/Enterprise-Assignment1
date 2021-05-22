package com.example.demo.user.entity.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.example.demo.user.entity.User;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken {
    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdTime;
    @Column(nullable = false)
    private LocalDateTime expiredTime;
    private LocalDateTime confirmedTime;

    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User user;

    public ConfirmationToken(String token, LocalDateTime createdTime, LocalDateTime expiredTime, User user) {
        this.token = token;
        this.createdTime = createdTime;
        this.expiredTime = expiredTime;
        this.user = user;
    }

}
