package com.portfolio.bugtracker.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The type Company tickets id.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CompanyTicketsId implements Serializable
{
    private long company;

    private long ticket;
    
    /**
     * Instantiates a new Company tickets id.
     *
     * @param companyid the companyid
     * @param ticketid  the ticketid
     */
    public CompanyTicketsId(long companyid, long ticketid)
    {
    }
}
