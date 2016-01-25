/**
 * 
 */
package org.project.service;

import java.util.List;

import org.project.model.Transaction;

/**
 * @author SMKUMBHA
 *
 */
public interface TransactionService {

	void saveTxn(Transaction transaction);

	List<Transaction> findTxnByType(String type);

	Transaction findTxnByID(long id);

	double getSumByParentid(long id);

	List<Transaction> findAllTxn();

}
