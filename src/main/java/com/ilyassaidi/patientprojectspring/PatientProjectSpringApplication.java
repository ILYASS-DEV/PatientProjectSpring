package com.ilyassaidi.patientprojectspring;

import com.ilyassaidi.patientprojectspring.entities.Patient;
import com.ilyassaidi.patientprojectspring.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PatientProjectSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientProjectSpringApplication.class, args);
    }

    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {

            patientRepository.save(
                    new Patient(null, "Ilyass", new Date(), false, 16));
            patientRepository.save(
                    new Patient(null, "Youssef", new Date(), true, 100));
            patientRepository.save(
                    new Patient(null, "Ali", new Date(), true, 156));
            patientRepository.save(
                    new Patient(null, "Sara", new Date(), false, 20));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };

    }
}
