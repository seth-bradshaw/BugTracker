package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Role to the rest of the application
 */
public interface RoleRepository extends CrudRepository<Role, Long>
{
	/**
	 * Find by name role.
	 *
	 * @param name the name of the role type
	 * @return the role
	 */
	Role findByName(String name);
}
