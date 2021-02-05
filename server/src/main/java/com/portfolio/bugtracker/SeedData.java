package com.portfolio.bugtracker;


import com.portfolio.bugtracker.models.Role;
import com.portfolio.bugtracker.models.User;
import com.portfolio.bugtracker.models.UserRoles;
import com.portfolio.bugtracker.services.RoleService;
import com.portfolio.bugtracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
@ConditionalOnProperty(prefix = "command.line.runner", value = "enabled", havingValue = "true", matchIfMissing = true)
public class SeedData implements CommandLineRunner
{
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Transactional

    @Override public void run(String... args) throws Exception
    {
        roleService.deleteAllRoles();
        userService.deleteAllUsers();

        Role r1 = new Role("ADMIN");
        r1 = roleService.save(r1);

        Role r2 = new Role("USER");
        r2 = roleService.save(r2);

        Role r3 = new Role("DATA");
        r3 = roleService.save(r3);

        User u1 = new User();
//		User u1 = new User("admin", "password", "admin@example.com");
        u1.setUserid(0);
        u1.setUsername("admin");
        u1.setPasswordEncrypt("password");
//        u1.setEmail("admin@example.com");
        u1.getRoles().clear();
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getRoles().add(new UserRoles(u1, r2));
        u1.getRoles().add(new UserRoles(u1, r3));
        u1 = userService.save(u1);

        User u2 = new User();
//		User u2 = new User("user1", "password", "user1@example.com");
        u2.setUserid(0);
        u2.setUsername("user1");
        u2.setPasswordEncrypt("password");
//        u2.setEmail("user1@example.com");
        u2.getRoles().clear();
//        u2.getRoles().add(new UserRole(u2, r2));
        u2 = userService.save(u2);

        User u3 = new User();
//		User u3 = new User("datauser", "password", "dateuser@example.com");
        u3.setUserid(0);
        u3.setUsername("datauser");
        u3.setPasswordEncrypt("password");
//        u3.setEmail("datauser@example.com");
        u3.getRoles().clear();
        u3.getRoles().add(new UserRoles(u3, r2));
        u3.getRoles().add(new UserRoles(u3, r3));
        u3 = userService.save(u3);
    }
}