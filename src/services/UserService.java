package services;

import classes.User;
import classes.Role;
import classes.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repos.interfaces.UserRepo;
import repos.interfaces.RoleRepo;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String login, String password, RoleType roleType) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));

        Role role = roleRepo.findByName(roleType).orElseThrow(() -> new RuntimeException("Role not found"));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        return userRepo.save(user);
    }
}
