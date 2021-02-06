package com.portfolio.bugtracker.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The entity allowing interaction with the userroles table. The join table between users and roles.
 * <p>
 * Table enforces a unique constraint of the combination of userid and roleid. These two together form the primary key.
 * <p>
 * When you have a compound primary key, you must implement Serializable for Hibernate When you implement Serializable
 * you must implement equals and hash code
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userroles")
@IdClass(UserRolesId.class)
public class UserRoles extends Auditable implements Serializable
{
	/**
	 * 1/2 of the primary key (long) for userroles.
	 * Also is a foreign key into the users table
	 */
	@Id
	@ManyToOne
	@NotNull
	@JoinColumn(name = "userid")
	@JsonIgnoreProperties(value = "roles", allowSetters = true)
	private User user;
	
	/**
	 * 1/2 of the primary key (long) for userroles.
	 * Also is a foreign key into the roles table
	 */
	@Id
	@ManyToOne
	@NotNull
	@JoinColumn(name = "roleid")
	@JsonIgnoreProperties(value = "users", allowSetters = true)
	private Role role;
}
