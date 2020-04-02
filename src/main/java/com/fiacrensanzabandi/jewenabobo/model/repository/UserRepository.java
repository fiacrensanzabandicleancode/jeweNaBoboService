package com.fiacrensanzabandi.jewenabobo.model.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fiacrensanzabandi.jewenabobo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    
	static Specification<User> hasName(String name) {
		return (user, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(user.get("name"), name);
	}
	
	static Specification<User> hasPassword(String password) {
		return (user, cq, cb) -> cb.equal(user.get("password"), password);
	}
	
	// TODO, peut être faut il faire une primary key id/name/password et récupérer le user by name & password.
	@Query(value ="select * from user where user.name = :name", nativeQuery = true)
	User findByName(String name);
	
	@Query(value = "select * from user where user.name = :name and user.password = :password", nativeQuery = true)
	User findByNameAndPassword(String name, String password);
}
