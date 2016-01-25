package org.project.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.project.model.Transaction;
import org.project.service.TransactionService;
import org.springframework.stereotype.Service;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	private static List<Transaction> transactions = new ArrayList<Transaction>();

	/*
	 * static{ transactions= getOldTxns(); }
	 */

	public void saveTxn(Transaction transaction) {
		// TODO Auto-generated method stub
		System.out.println(transaction.getParent_id());
		transactions.add(transaction);

	}

	public List<Transaction> findTxnByType(String type) {

		List transactionstype = new ArrayList<Transaction>();
		for (Transaction transaction : transactions) {

			if (transaction.getType().equals(type)) {
				transactionstype.add(transaction.getTransaction_id());

			}
		}

		// TODO Auto-generated method stub
		return transactionstype;
	}

	public Transaction findTxnByID(long id) {
		// TODO Auto-generated method stub
		for (Transaction transaction : transactions) {
			if (transaction.getTransaction_id() == id) {
				return transaction;
			}
		}
		return null;
	}

	public double getSumByParentid(long id) {

		double finalsum = 0.0;
		double totalsum = 0.0;
		double originalsum = 0.0;

		for (Transaction transaction : transactions) {
			if (transaction.getParent_id() == id) {
				totalsum = totalsum + transaction.getAmmount();

			}

		}

		try {
			originalsum = findTxnByID(id).getAmmount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalsum = totalsum + originalsum;

		// TODO Auto-generated method stub
		return finalsum;
	}

	public List<Transaction> findAllTxn() {

		return transactions;
	}

}
