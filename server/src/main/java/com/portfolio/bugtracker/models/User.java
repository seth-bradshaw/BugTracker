package com.portfolio.bugtracker.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The entity allowing interaction with the users table
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User extends Auditable
{
	/**
	 * The primary key (long) of the users table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userid;
	
	/**
	 * The username (String). Cannot be null and must be unique
	 */
	@NotNull
	@NonNull
	@Column(unique = true)
	private String username;
	
	/**
	 * The password (String) for this user. Cannot be null. Never get displayed
	 */
	@NotNull
	@NonNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = "employee", allowSetters = true)
	private Set<CompanyEmployees> companies = new HashSet<>();

	/**
	 * Part of the join relationship between user and role
	 * connects users to the user role combination
	 */
	@OneToMany(mappedBy = "user",
	           cascade = CascadeType.ALL,
	           orphanRemoval = true)
	@JsonIgnoreProperties(value = "user",
	                      allowSetters = true)
	private Set<UserRoles> roles = new HashSet<>();
	
	/**
	 * Sets password encrypt.
	 *
	 * @param password the password
	 */
	public void setPasswordEncrypt(String password)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		setPassword(encoder.encode(password));
	}
	
	/**
	 * Internally, user security requires a list of authorities, roles, that the user has. This method is a simple way
	 * to provide those. Note that SimpleGrantedAuthority requests the format ROLE_role name all in capital letters!
	 *
	 * @return The list of authorities, roles, this user object has
	 */
	@JsonIgnore
	public List<SimpleGrantedAuthority> getAuthority()
	{
		List<SimpleGrantedAuthority> rtnList = new ArrayList<>();
		
		for (UserRoles r : this.roles)
		{
			String myRole = "ROLE_" + r.getRole()
					.getName()
					.toUpperCase();
			rtnList.add(new SimpleGrantedAuthority(myRole));
		}
		
		return rtnList;
	}
}
