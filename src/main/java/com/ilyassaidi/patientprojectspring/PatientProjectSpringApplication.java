package com.ilyassaidi.patientprojectspring;

import com.ilyassaidi.patientprojectspring.entities.Patient;
import com.ilyassaidi.patientprojectspring.repositories.PatientRepository;
import com.ilyassaidi.patientprojectspring.sec.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientProjectSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientProjectSpringApplication.class, args);
    }
    /*@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args ->{
            patientRepository.save(new Patient(null,"Ahmed",new Date(),false,102));
            patientRepository.save(new Patient(null,"Zakaria",new Date(),false,516));
            patientRepository.save(new Patient(null,"Ali",new Date(),true,433));
            patientRepository.save(new Patient(null,"Najwa",new Date(),false,10));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };*/

    /*@Bean
    CommandLineRunner saveusers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("ilyass2", "1234", "1234");
            securityService.saveNewUser("youssef2", "1234", "1234");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("ilyass2", "USER");
            securityService.addRoleToUser("ilyass2", "ADMIN");

            securityService.addRoleToUser("youssef2", "USER");


        };*/

}


