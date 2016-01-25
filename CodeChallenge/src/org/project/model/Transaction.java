package org.project.model;

public class Transaction {

	private long transaction_id;

	private double ammount;

	private String type;

	private long parent_id;

	/**
	 * @return the transaction_id
	 */
	public long getTransaction_id() {
		return transaction_id;
	}

	/**
	 * @param transaction_id
	 *            the transaction_id to set
	 */
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * @return the ammount
	 */
	public double getAmmount() {
		return ammount;
	}

	/**
	 * @param ammount
	 *            the ammount to set
	 */
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the parent_id
	 */
	public long getParent_id() {
		return parent_id;
	}

	/**
	 * @param parent_id
	 *            the parent_id to set
	 */
	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}

}
