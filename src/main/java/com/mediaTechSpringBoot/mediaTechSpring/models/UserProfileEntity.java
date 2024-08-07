package com.mediaTechSpringBoot.mediaTechSpring.models;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "profiles")
@AllArgsConstructor
public class UserProfileEntity implements Serializable{ 


    @Id
    @GeneratedValue
    private Integer id;


    @Column(nullable = false)
    private String avatar;


    @Column(nullable = false)
    private String telephone;


    // Relation One To One    UserProfile => User
    @OneToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;
}