package com.portfolio.bugtracker.services;


import com.portfolio.bugtracker.models.Role;

/**
 * The service that works with the Role Model.
 * <p>
 * Note: no method update Role name
 */
public interface RoleService
{
	/**
	 * Find the first Role object matching the given name
	 *
	 * @param name The name (String) of the role you seek
	 * @return The Role object matching the given name
	 */
	Role findByName(String name);
	
	/**
	 * Delete all roles.
	 */
	void deleteAllRoles();
	
	/**
	 * Save role.
	 *
	 * @param role the role
	 * @return the role
	 * @throws Exception the exception
	 */
	Role save(Role role) throws Exception;
}