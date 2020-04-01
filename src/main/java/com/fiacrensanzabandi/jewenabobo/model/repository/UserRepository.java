package com.fiacrensanzabandi.jewenabobo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiacrensanzabandi.jewenabobo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// TODO, peut être faut il faire une primary key id/name/password et récupérer le user by name & password.
	@Query(value ="select * from user where user.name = :name", nativeQuery = true)
	User findByName(String name);
	
	@Query(value = "select * from user where user.name = :name and user.password = :password", nativeQuery = true)
	User findByNameAndPassword(String name, String password);
}
