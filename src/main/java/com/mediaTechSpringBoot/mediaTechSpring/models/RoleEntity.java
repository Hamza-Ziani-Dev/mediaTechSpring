package com.mediaTechSpringBoot.mediaTechSpring.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity implements Serializable {


    @Id()
    private Integer roleId;

    @Column(nullable = false)
    private String name;



   
    //  Relation Many To Many    Role => User
    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<UserEntity> users;
    
}