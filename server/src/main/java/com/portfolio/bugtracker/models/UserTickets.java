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
@RequiredArgsConstructor
@Table(name = "usertickets")
@IdClass(UserTicketsId.class)
public class UserTickets extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @NotNull
    @NonNull
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "tickets", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @NotNull
    @NonNull
    @JoinColumn(name = "ticketid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Ticket ticket;
}
