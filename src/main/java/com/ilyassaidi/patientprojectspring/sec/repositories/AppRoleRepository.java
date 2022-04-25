package com.ilyassaidi.patientprojectspring.sec.repositories;

import com.ilyassaidi.patientprojectspring.sec.AppRole;
import com.ilyassaidi.patientprojectspring.sec.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
    AppRole findByRoleName(String roleName);
}
