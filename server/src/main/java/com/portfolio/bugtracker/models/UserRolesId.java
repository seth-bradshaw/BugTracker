package com.portfolio.bugtracker.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Class to represent the complex primary key for UserRoles
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class UserRolesId implements Serializable
{
	/**
	 * The id of the user
	 */
	private long user;
	
	/**
	 * The id of the role
	 */
	private long role;
	
	public UserRolesId(long user, long role)
	{
	}
}
