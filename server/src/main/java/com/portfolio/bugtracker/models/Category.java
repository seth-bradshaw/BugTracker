package com.portfolio.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryid;

    @NonNull
    private String categorytype;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"category"}, allowSetters = true)
    private Set<TicketCategories> tickets = new HashSet<>();
}
