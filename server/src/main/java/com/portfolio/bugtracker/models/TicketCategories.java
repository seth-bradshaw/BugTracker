package com.portfolio.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticketcategories")
@IdClass(TicketCategoriesId.class)
public class TicketCategories extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "ticketid")
    @JsonIgnoreProperties(value = "categories", allowSetters = true)
    private Ticket ticket;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "categoryid")
    @JsonIgnoreProperties(value = "tickets", allowSetters = true)
    private Category category;
}
