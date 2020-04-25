package com.fiacrensanzabandi.jewenabobo.model.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fiacrensanzabandi.jewenabobo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	/**
	 * Returns specified users with the name passed in parameter.
	 * 
	 * @param name
	 * @return User
	 * @author fnsanzabandi
	 */
	static Specification<User> hasName(String name) {
		return (user, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(user.get("name"), name);
	}

	/**
	 * Returns specified users with the password in parameter.
	 * 
	 * @param password
	 * @return User
	 * @author fnsanzabandi
	 */
	static Specification<User> hasPassword(String password) {
		return (user, cq, cb) -> cb.equal(user.get("password"), password);
	}

}
