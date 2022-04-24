package com.ilyassaidi.patientprojectspring;

import com.ilyassaidi.patientprojectspring.entities.Patient;
import com.ilyassaidi.patientprojectspring.repositories.PatientRepository;
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
   /* @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args ->{
            patientRepository.save(new Patient(null,"Ilyass",new Date(),false,102));
            patientRepository.save(new Patient(null,"Youssef",new Date(),false,516));
            patientRepository.save(new Patient(null,"Kawtar",new Date(),true,433));
            patientRepository.save(new Patient(null,"Chaimaa",new Date(),false,10));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };*/

}
