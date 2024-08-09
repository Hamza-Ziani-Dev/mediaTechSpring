package com.mediaTechSpringBoot.mediaTechSpring.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
// import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity  implements Serializable{


    @Id()
    private Integer userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;




    //  Relation Many To Many    User => Role
    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<RoleEntity> roles;






    //  Relation One To One    User => UserProfile
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private UserProfileEntity userProfile;

    
}