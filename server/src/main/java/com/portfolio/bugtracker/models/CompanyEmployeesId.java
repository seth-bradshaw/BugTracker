package com.portfolio.bugtracker.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The type Company employees id.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CompanyEmployeesId implements Serializable
{
    private long company;

    private long employee;
    
    public CompanyEmployeesId(long company, long employee)
    {
    }
}
