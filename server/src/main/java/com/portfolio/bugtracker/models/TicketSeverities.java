package com.portfolio.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticketseverities")
@IdClass(TicketSeveritiesId.class)
public class TicketSeverities extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "ticketid")
    @JsonIgnoreProperties(value = "severities", allowSetters = true)
    private Ticket ticket;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "severityid")
    @JsonIgnoreProperties(value = "tickets", allowSetters = true)
    private Severity severity;
}
