package ru.kata.spring.boot_security.demo.starts;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;
@Component
public class Start {
    private final UserService userService;
    private final RoleService roleService;

    public Start(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void startUsers() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);
        User user = new User("Ivan","admin","Vetrov","admin",32, Set.of(roleAdmin));
        User user1 = new User("Victor","user","Petrov","user",24,Set.of(roleUser));
        User user2 = new User("Sofia","user1","Larina","user1",28,Set.of(roleUser));
        userService.saveUser(user);
        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
