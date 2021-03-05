package com.portfolio.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "statuses")
public class Status extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long statusid;

    @NotNull
    @NonNull
    private String statustype;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"status", "users", "category"}, allowSetters = true)
    private List<Ticket> tickets = new ArrayList<>();
}
