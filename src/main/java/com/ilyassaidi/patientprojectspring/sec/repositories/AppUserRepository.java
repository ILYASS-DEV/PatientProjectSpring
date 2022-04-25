package com.ilyassaidi.patientprojectspring.sec.repositories;

import com.ilyassaidi.patientprojectspring.sec.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
