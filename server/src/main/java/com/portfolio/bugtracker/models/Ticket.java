package com.portfolio.bugtracker.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Ticket.
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketid;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompanyTickets> companies = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @NonNull
    private String title;
    private String description;
    private String status;
    private String errorcode;
    private String errorcategory;
    private String notes;
}
