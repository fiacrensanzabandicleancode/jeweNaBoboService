package com.fiacrensanzabandi.jewenabobo.service;

import com.fiacrensanzabandi.jewenabobo.model.User;

/**
 * User service.
 * 
 * @author fnsanzabandi
 *
 */
public interface UserService {

	/**
	 * finds user by name.
	 * 
	 * @param user
	 * @return User
	 * @author fnsanzabandi
	 */
	User findUserByName(User user);

	/**
	 * Verifies if user exists.
	 * 
	 * @param user
	 * @return true or false
	 * @author fnsanzabandi
	 */
	boolean verifyIfUserExists(User user);

	/**
	 * adds the user.
	 * 
	 * @param user
	 * @author fnsanzabandi
	 */
	void addUser(User user);
}
