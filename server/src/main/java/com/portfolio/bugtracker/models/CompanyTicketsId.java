package com.portfolio.bugtracker.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CompanyTicketsId implements Serializable
{
    private long company;

    private long ticket;

    public CompanyTicketsId(long companyid, long ticketid)
    {
    }
}
