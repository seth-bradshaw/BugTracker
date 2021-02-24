package com.portfolio.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticketstatuses")
@IdClass(TicketStatusesId.class)
public class TicketStatuses extends Auditable
{
    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "ticketid")
    @JsonIgnoreProperties(value = "statuses", allowSetters = true)
    private Ticket ticket;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "statusid")
    @JsonIgnoreProperties(value = "tickets", allowSetters = true)
    private Status status;
}
