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
public class TicketSeveritiesId implements Serializable
{
    private long ticket;

    private long severity;

    public TicketSeveritiesId(long ticket, long severity)
    {
    }
}
