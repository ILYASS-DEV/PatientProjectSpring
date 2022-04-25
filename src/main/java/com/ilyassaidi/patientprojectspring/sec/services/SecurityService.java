package com.ilyassaidi.patientprojectspring.sec.services;

import com.ilyassaidi.patientprojectspring.sec.AppRole;
import com.ilyassaidi.patientprojectspring.sec.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username , String password, String rePass);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username , String roleName);
    void removeRoleToUser(String username , String roleName);
    AppUser loadUserByUsername(String username);

}
