package com.portfolio.bugtracker.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Company.
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long companyid;

    @NonNull
    private String companyname;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompanyEmployees> employees = new HashSet<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompanyTickets> tickets = new HashSet<>();
}
