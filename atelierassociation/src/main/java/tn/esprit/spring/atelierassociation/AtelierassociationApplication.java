package tn.esprit.spring.atelierassociation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EntityScan(basePackages ={"tn.esprit.spring.atelierassociation.entity"})
@ComponentScan(basePackages = {"tn.esprit.spring.atelierassociation.controllers","tn.esprit.spring.atelierassociation.services"})
@EnableJpaRepositories(basePackages = {"tn.esprit.spring.atelierassociation.repositeries"})
@Slf4j


public class AtelierassociationApplication {

    public static void main(String[] args) {
        log.info("hii");

        SpringApplication.run(AtelierassociationApplication.class, args);
    }
}
