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
public class UserTicketsId implements Serializable
{
    private long user;

    private long ticket;

    public UserTicketsId(long user, long ticket)
    {
        this.user = user;
        this.ticket = ticket;
    }
}
