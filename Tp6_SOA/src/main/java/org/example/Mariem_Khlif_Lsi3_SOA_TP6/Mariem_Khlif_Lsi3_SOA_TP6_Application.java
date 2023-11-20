package org.example.Mariem_Khlif_Lsi3_SOA_TP6;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.example.entities.Compte;
import org.example.entities.EtatCompte;
import org.example.entities.TypeCompte;
import org.example.repositories.CompteRepository;
import org.example.entities.Compte;
import org.example.entities.EtatCompte;
import org.example.entities.TypeCompte;
import org.example.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.repositories")
@EntityScan("org.example.entities")
@ComponentScan("org.example")
public class Mariem_Khlif_Lsi3_SOA_TP6_Application {

    public static void main(String[] args)
    {
        SpringApplication.run(Mariem_Khlif_Lsi3_SOA_TP6_Application.class,args);
    }
   @Bean
    public CommandLineRunner initData (CompteRepository compteRepository)
    {
        return (args)->
        {
            compteRepository.save(new Compte(null, 1000, new Date(), TypeCompte.COURANT, EtatCompte.ACTIVE));
            compteRepository.save(new Compte(null, 500, new Date(), TypeCompte.EPARGNE, EtatCompte.CREE));
            compteRepository.save(new Compte(null, 200, new Date(), TypeCompte.EPARGNE, EtatCompte.BLOQUE));
            List<Compte> comptes = compteRepository.findAll();
            for (Compte compte : comptes) {
                System.out.println("Solde du compte " + compte.getId() + ": " + compte.getSolde());
            }
        };
    }
}