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
@AllArgsConstructor
@JsonIgnoreProperties(value = "companies", allowSetters = true)
@Entity
@Table(name = "tickets")
public class Ticket extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketid;

    @NonNull
    private String title;
    private String description;
    private String errorcode;
    private String notes;
    private String severity;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"ticket"}, allowSetters = true)
    private Set<UserTickets> users = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = {"tickets"})
    private Category category;

    @ManyToOne
    @JsonIgnoreProperties(value = {"tickets"})
    private Status status;
}
