package com.capgemini.analyser;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		FraudAnalyserImpl analyser = new FraudAnalyserImpl();
		Transaction t1 = new Transaction(100, 201, 5500);
		Transaction t2 = new Transaction(105, 202, 5600);
		Transaction t3 = new Transaction(100, 203, 5700);
		Transaction t4 = new Transaction(105, 204, 5800);
		Transaction t5 = new Transaction(10, 24, 15800);
		
		List<Transaction> allTransactions = new ArrayList<Transaction>();
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		allTransactions.add(t4);
		allTransactions.add(t5);
		
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByID();
	}

}
