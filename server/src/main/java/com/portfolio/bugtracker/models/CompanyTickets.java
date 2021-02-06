package com.portfolio.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The type Company tickets.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "companytickets")
@IdClass(CompanyTicketsId.class)
public class CompanyTickets extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "companyid")
    @JsonIgnoreProperties(value = {"tickets", "employees", "company"}, allowSetters = true)
    private Company company;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "ticketid")
    @JsonIgnoreProperties(value = "companies", allowSetters = true)
    private Ticket ticket;
}
