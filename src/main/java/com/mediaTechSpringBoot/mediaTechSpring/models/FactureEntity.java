package com.mediaTechSpringBoot.mediaTechSpring.models;

import java.util.Date;

// import javax.persistence.Entity;
// import javax.persistence.Table;

import jakarta.persistence.*;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "factures")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class FactureEntity {

    @Id()
    private Integer id;

    @Column(nullable = false,name = "facture_reference")
    private String ref;

 
    @Column(nullable = false,name = "facture_date")
    private Date date;



    // Relation ManyToOne
    @ManyToOne
    private ClientEntity client;



    
}