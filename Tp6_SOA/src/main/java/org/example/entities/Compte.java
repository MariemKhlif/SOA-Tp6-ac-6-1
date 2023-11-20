package org.example.entities;
import jakarta.persistence.*;
import lombok.*;
import java.lang.reflect.Type;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Column
    double solde ;
    @Column
    Date dateCreation;
    @Column
    TypeCompte type;
    @Column
    EtatCompte etat ;
}
