package com.portfolio.bugtracker.services;


import com.portfolio.bugtracker.models.User;

/**
 * The Service that works with User Model.
 * <p>
 * Note: Emails are added through the add user process Roles are added through the add user process No way to delete an
 * assigned role
 */
public interface UserService
{
	/**
	 * Returns the user with the given name
	 *
	 * @param name The full name (String) of the User you seek.
	 * @return The User with the given name or throws an exception if not found.
	 */
	User findByName(String name);
	
	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the user
	 */
	User save(User user);
	
	/**
	 * Delete all users.
	 */
	void deleteAllUsers();
	
	/**
	 * Find user by id user.
	 *
	 * @param userid the userid
	 * @return the user
	 * @throws Exception the exception
	 */
	User findUserById(long userid) throws Exception;
}