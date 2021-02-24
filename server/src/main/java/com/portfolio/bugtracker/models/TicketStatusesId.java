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
public class TicketStatusesId implements Serializable
{
    private long ticket;

    private long status;

    public TicketStatusesId(long ticket, long status)
    {
    }
}
