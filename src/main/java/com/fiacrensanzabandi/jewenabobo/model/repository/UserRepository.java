package com.fiacrensanzabandi.jewenabobo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiacrensanzabandi.jewenabobo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// TODO, peut être faut il faire une primary key id/name/password et récupérer le user by name & password.
	@Query("select u from User u where u.name = :name")
	User findByName(String name);
}
