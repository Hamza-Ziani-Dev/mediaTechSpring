package com.mediaTechSpringBoot.mediaTechSpring.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

// import javax.persistence.Entity;
// import javax.persistence.Table;

// import jakarta.persistence.*;
// import javax.persistence.*;
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

public class FactureEntity  implements Serializable{

    @Id()
    private Integer id;

    @Column(nullable = false,name = "facture_reference")
    private String ref;

 
    @Column(nullable = false,name = "facture_date")
    private Date date;


    // Relation One To One    Facture => Client
    @ManyToOne
    private ClientEntity client;


    //  Relation One To Many    Facture => LigneFacture
    @OneToMany(mappedBy = "facture",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LigneFactureEntity> ligneFacture;



    
}