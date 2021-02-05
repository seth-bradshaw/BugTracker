package com.portfolio.bugtracker.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the roles table.
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "roles")
public class Role
{
	/**
	 * The primary key (long) of the roles table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleid;
	
	/**
	 * The name (String) of the role. Cannot be null and must be unique.
	 */
	@NotNull
	@NonNull
	@Column(unique = true)
	private String name;
	
	
	/**
	 * Part of the join relationship between user and role connects roles to the user role combination
	 */
	@OneToMany(mappedBy = "role",
	           cascade = CascadeType.ALL,
	           orphanRemoval = true)
	@JsonIgnoreProperties(value = "role",
	                      allowSetters = true)
	private Set<UserRoles> users = new HashSet<>();
}
