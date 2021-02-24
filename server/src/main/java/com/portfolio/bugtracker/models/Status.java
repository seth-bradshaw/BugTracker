package com.portfolio.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "statuses")
public class Status extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long statusid;

    @NotNull
    private String statustype;

    @NotNull
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"status"})
    private Set<TicketStatuses> tickets = new HashSet<>();
}
