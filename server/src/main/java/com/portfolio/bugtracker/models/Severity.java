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
@Table(name = "severities")
public class Severity extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long severityid;

    private long severitylevel;

    @OneToMany(mappedBy = "severity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"severity"}, allowSetters = true)
    private Set<TicketSeverities> tickets = new HashSet<>();
}
