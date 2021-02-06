package com.portfolio.bugtracker.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CompanyEmployeesId implements Serializable
{
    private long company;

    private long employee;
}
