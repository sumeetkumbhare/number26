package org.project.controller;

import java.util.List;

import org.project.model.Transaction;
import org.project.service.TransactionService;
import org.project.serviceImpl.TransactionServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author SMKUMBHA
 *
 */
@RestController
public class TransactionController {

	TransactionService transactionservice = new TransactionServiceImpl();

	@RequestMapping(value = "/transaction/{id}", method = RequestMethod.PUT, consumes = { "application/xml",
	"application/json" })
	public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction, @PathVariable("id") long id,
			UriComponentsBuilder ucBuilder) {

		System.out.println("::" + transaction.getAmmount());
		transaction.setTransaction_id(id);
		transactionservice.saveTxn(transaction);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				ucBuilder.path("/transaction/{id}").buildAndExpand(transaction.getTransaction_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/types/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List> getTransaction(@PathVariable("type") String type) {
		List<Transaction> transaction = transactionservice.findTxnByType(type);

		if (transaction == null) {
			return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List>(transaction, HttpStatus.OK);
	}

	@RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transaction> getTransaction(@PathVariable("id") long id) {
		System.out.println("id" + id);
		Transaction transaction = transactionservice.findTxnByID(id);
		if (transaction == null) {

			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@RequestMapping(value = "/sum/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getSumofTxn(@PathVariable("id") long id) {

		double sumoftxn = transactionservice.getSumByParentid(id);
		if (sumoftxn == 0.0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Double>(sumoftxn, HttpStatus.OK);

	}

	@RequestMapping(value = "/transaction/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaction>> listAllTransactions() {
		System.out.println("in transaction Service");
		List<Transaction> transaction = transactionservice.findAllTxn();
		return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	}

}
