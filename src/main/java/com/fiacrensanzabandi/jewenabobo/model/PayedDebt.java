package com.fiacrensanzabandi.jewenabobo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Represents payed debts for a user
 * 
 * @author fnsanzabandi
 *
 */
@Entity
public class PayedDebt implements Serializable {

	private static final long serialVersionUID = 4708198247521204638L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	private double amount;
	private Date paymentDate;

	public long getId() {
		return id;
	}

	public void setId(long payedDeptId) {
		this.id = payedDeptId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	// TODO generate equals
}
