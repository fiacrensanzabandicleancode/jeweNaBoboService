package com.fiacrensanzabandi.jewenabobo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Represents a user.
 * 
 * @author fnsanzabandi
 *
 */
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -1534166064457090868L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String password;
	private double debt;
	private double interest;
	private double payedDebtsAmount;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<PayedDebt> payedDebtHistory;

	public long getId() {
		return id;
	}

	public void setId(long userId) {
		this.id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getPayedDebtsAmount() {
		return payedDebtsAmount;
	}

	public void setPayedDebtsAmount(double payedDebtAmount) {
		this.payedDebtsAmount = payedDebtAmount;
	}

	public List<PayedDebt> getPayedDebtHistory() {
		return payedDebtHistory;
	}

	public void setPayedDebtHistory(List<PayedDebt> payedDeptHistory) {
		this.payedDebtHistory = payedDeptHistory;
	}

	// TODO generate equals

}
