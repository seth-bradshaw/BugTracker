package com.portfolio.bugtracker;

import com.portfolio.bugtracker.models.*;
import com.portfolio.bugtracker.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * The type Seed data.
 */
@Component
@Transactional
@ConditionalOnProperty(prefix = "command.line.runner", value = "enabled", havingValue = "true", matchIfMissing = true)
public class SeedData implements CommandLineRunner
{
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private CategoryService categoryService;

    @Transactional
    @Override public void run(String... args) throws Exception
    {
        roleService.deleteAllRoles();
        userService.deleteAllUsers();
        companyService.deleteAllCompanies();
        ticketService.deleteAllTickets();

        Role r1 = new Role("ADMIN");
        r1 = roleService.save(r1);

        Role r2 = new Role("USER");
        r2 = roleService.save(r2);

        Role r3 = new Role("DATA");
        r3 = roleService.save(r3);

        Company c1 = new Company();
        c1.setCompanyname("Bezos Bucks");
        c1 = companyService.save(c1);

        Company c2 = new Company();
        c2.setCompanyname("Food for tha poor");
        c2 = companyService.save(c2);

        User u1 = new User();
        u1.setUsername("admin");
        u1.setPasswordEncrypt("password");
        u1.setEmail("admin@example.com");
        u1.getRoles().clear();
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getRoles().add(new UserRoles(u1, r2));
        u1.getRoles().add(new UserRoles(u1, r3));
        u1.setCompany(c1);
        u1 = userService.save(u1);

        User u2 = new User();
        u2.setUsername("user1");
        u2.setPasswordEncrypt("password");
        u2.setEmail("user1@example.com");
        u2.getRoles().clear();
        u2.getRoles().add(new UserRoles(u2, r2));
        u2.setCompany(c1);
        u2 = userService.save(u2);

        User u3 = new User();
        u3.setUsername("datauser");
        u3.setPasswordEncrypt("password");
        u3.setEmail("datauser@example.com");
        u3.getRoles().clear();
        u3.getRoles().add(new UserRoles(u3, r2));
        u3.getRoles().add(new UserRoles(u3, r3));
        u3.setCompany(c1);
        u3 = userService.save(u3);

        Ticket t1 = new Ticket();
        t1.setTitle("THIS IS TICKET 1");
        t1.setDescription("I encountered my first error!");
        t1.setErrorcode("12345");
        t1.setNotes("Here is some notes about the issue.");
        t1.setSeverity("uno");
        t1 = ticketService.save(t1);
        t1.getUsers().add(new UserTickets(u1, t1));

        Ticket t2 = new Ticket();
        t2.setTitle("THIS IS TICKET 2");
        t2.setDescription("I encountered my first error!");
        t2.setErrorcode("12345");
        t2.setNotes("Here is some notes about the issue.");
        t2.setSeverity("uno");
        t2 = ticketService.save(t2);
        t1.getUsers().add(new UserTickets(u1, t2));

        Ticket t3 = new Ticket();
        t3.setTitle("THIS IS TICKET 3");
        t3.setDescription("I encountered my first error!");
        t3.setErrorcode("12345");
        t3.setNotes("Here is some notes about the issue.");
        t3.setSeverity("uno");
        t3 = ticketService.save(t3);
        t1.getUsers().add(new UserTickets(u1, t3));
        t1.getUsers().add(new UserTickets(u2, t3));

        Status s1 = new Status();
        s1.setStatustype("Not Started");
        s1 = statusService.save(s1);
        t1.setStatus(s1);
        t2.setStatus(s1);
//        t3.setStatus(s1);

        Status s2 = new Status();
        s2.setStatustype("In Progress");
        s2 = statusService.save(s2);

        Status s3 = new Status();
        s3.setStatustype("Completed");
        s3 = statusService.save(s3);
        t3.setStatus(s3);

        Category cat1 = new Category();
        cat1.setCategorytype("Testing");
//        cat1.getTickets().add(t1);
//        cat1.getTickets().add(t2);
//        cat1.getTickets().add(t3);
        cat1 = categoryService.save(cat1);
        t1.setCategory(cat1);
        t2.setCategory(cat1);
        t3.setCategory(cat1);

        t1 = ticketService.save(t1);
        t2 = ticketService.save(t2);
        t3 = ticketService.save(t3);
        u1.getTickets().add(new UserTickets(u1, t1));
        u1.getTickets().add(new UserTickets(u1, t2));
        u1.getTickets().add(new UserTickets(u1, t3));
        u1 = userService.save(u1);
        u2.getTickets().add(new UserTickets(u2, t2));
        u2 = userService.save(u2);
        u3.getTickets().add(new UserTickets(u3, t3));
        u3 = userService.save(u3);
    }
}