package com.devthao.animecenter.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false, length = 500)
    private String deviceInfo;

    @Column(nullable = false)
    private Date issuedAt;

    @Column(nullable = false)
    private Date expiresAt;

    // Getters and setters
}


