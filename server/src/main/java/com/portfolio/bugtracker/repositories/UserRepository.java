package com.portfolio.bugtracker.repositories;


import com.portfolio.bugtracker.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The CRUD repository connecting User to the rest of the application
 */
public interface UserRepository
		extends CrudRepository<User, Long>
{
	/**
	 * Find a user based off over username
	 *
	 * @param username the name (String) of user you seek
	 * @return the first user object with the name you seek
	 */
	User findByUsername(String username);

	@Query(value = "SELECT u FROM User u WHERE u.company.companyid = ?1")
    List<User> findUserByCompany(long companyid);
}
