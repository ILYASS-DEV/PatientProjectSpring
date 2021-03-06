package com.ilyassaidi.patientprojectspring.sec.services;

import com.ilyassaidi.patientprojectspring.sec.AppRole;
import com.ilyassaidi.patientprojectspring.sec.AppUser;
import com.ilyassaidi.patientprojectspring.sec.repositories.AppRoleRepository;
import com.ilyassaidi.patientprojectspring.sec.repositories.AppUserRepository;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public AppUser saveNewUser(String username, String password, String rePass) {
        if (!password.equals(rePass)) throw new RuntimeException("Passwords are not matching");
        String hashedPWD=passwordEncoder.encode(password);
        AppUser appUser = new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(password);
        appUser.setActive(true);
        AppUser savedAppUser = appUserRepository.save(appUser);

        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole != null) throw new RuntimeException("Role" + roleName + "already exists");

        appRole = new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        appRoleRepository.save(appRole);

        return appRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) throw new RuntimeException("User not found");

        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole != null) throw new RuntimeException("Role not found");

        appUser.getAppRoles().add(appRole);
        appUserRepository.save(appUser);
    }

    @Override
    public void removeRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) throw new RuntimeException("User not found");

        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole != null) throw new RuntimeException("Role not found");

        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {

        return appUserRepository.findByUsername(username);
    }
}
