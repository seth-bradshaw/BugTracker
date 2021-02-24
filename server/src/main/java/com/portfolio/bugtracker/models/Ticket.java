package com.portfolio.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = "companies", allowSetters = true)
@Entity
@Table(name = "tickets")
public class Ticket extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketid;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"tickets","ticket"}, allowSetters = true)
    private Set<CompanyTickets> companies = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = {"companies"}, allowSetters = true)
    private User user;

    @NonNull
    private String title;
    private String description;
    private String errorcode;
    private String notes;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"ticket"})
    private Set<TicketCategories> categories = new HashSet<>();

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"ticket"})
    private Set<TicketStatuses> statuses = new HashSet<>();

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"ticket"})
    private Set<TicketSeverities> severities = new HashSet<>();

}
