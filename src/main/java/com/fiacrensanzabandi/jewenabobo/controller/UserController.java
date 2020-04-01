package com.fiacrensanzabandi.jewenabobo.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiacrensanzabandi.jewenabobo.model.User;
import com.fiacrensanzabandi.jewenabobo.service.UserService;

/**
 * User rest controller
 * @author fnsanzabandi
 *
 */
@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**	
	 * Finds a user by name.
	 * @param user
	 * @return a response entity
	 * @author fnsanzabandi
	 */
	@RequestMapping(value = "/getUserByName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUserByName(@RequestBody @NotNull User user) {
		return ResponseEntity.ok().body(userService.findUserByName(user));
	}
	
	/**
	 * Verify if a user exists.
	 * @param user
	 * @return a response entity
	 */
	@RequestMapping(value = "/verifyIfUserExists", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> verifyIfUserExists(@RequestBody @NotNull User user) {
		return ResponseEntity.ok().body(userService.verifyIfUserExists(user));
	}
	
	/**
	 * Adds a user.
	 * @param user
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody @NotNull User user) {
		userService.addUser(user);
	}
	
	// TODO: add payed dept and update the payedDebtsAmount
	
	// TODO: get all users to be rendered on the view
}
