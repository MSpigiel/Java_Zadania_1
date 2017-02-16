package com.capgemini.analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FraudAnalyserImpl {

	Map<Integer, Map<String, ArrayList<Transaction>>> transactionsTree = new HashMap<Integer, Map<String, ArrayList<Transaction>>>();
	public List<Transaction> suspiciousTransactions;
	List<Integer> suspiciousIDs;
	List<Integer> trustworthyIDs;
	List<SuspiciousPattern> patterns;

	public FraudAnalyserImpl() {
		suspiciousTransactions = new ArrayList<Transaction>();
		suspiciousIDs = new ArrayList<Integer>();
		trustworthyIDs = new ArrayList<Integer>();
		suspiciousIDs.add(542);
		suspiciousIDs.add(1052);
		suspiciousIDs.add(2103);
		trustworthyIDs.add(101);
		trustworthyIDs.add(106);

	}

	public void generateTransactionTree(List<Transaction> transactionList) {
		for (Transaction trans : transactionList) {
			if (trustworthyIDs.contains(trans.getFromUserID())) {
				continue;
			}
			if (transactionsTree.containsKey(trans.getFromUserID())) {
				if (transactionsTree.get(trans.getFromUserID()).containsKey(trans.getDateIdentifier())) {
					transactionsTree.get(trans.getFromUserID()).get(trans.getDateIdentifier()).add(trans);
				} else {
					transactionsTree.get(trans.getFromUserID()).put(trans.getDateIdentifier(),
							new ArrayList<Transaction>());
					transactionsTree.get(trans.getFromUserID()).get(trans.getDateIdentifier()).add(trans);
				}
			} else {
				transactionsTree.put(trans.getFromUserID(), new HashMap<String, ArrayList<Transaction>>());
				transactionsTree.get(trans.getFromUserID()).put(trans.getDateIdentifier(),
						new ArrayList<Transaction>());
				transactionsTree.get(trans.getFromUserID()).get(trans.getDateIdentifier()).add(trans);
			}
		}

	}

	public void searchSuspiciousTransactionsByID() {
		for (int i = 0; i < suspiciousIDs.size(); i++) {
			if (transactionsTree.containsKey(suspiciousIDs.get(i))) {
				for (Map.Entry<String, ArrayList<Transaction>> entry : transactionsTree.get(suspiciousIDs.get(i))
						.entrySet()) {
					for (Transaction suspiciousTrans : entry.getValue()) {
						suspiciousTransactions.add(suspiciousTrans);
						transactionsTree.remove(suspiciousIDs.get(i));
					}

				}
			}
		}
	}

	public void searchSuspiciousTransactionsByPattern(List<SuspiciousPattern> patterns) {
		for (SuspiciousPattern pattern : patterns) {
			for (Map.Entry<Integer, Map<String, ArrayList<Transaction>>> entry : transactionsTree.entrySet()) {
				for (Map.Entry<String, ArrayList<Transaction>> trans : entry.getValue().entrySet()) {
					List<Transaction> temp = new ArrayList<Transaction>();
					copyTransactions(pattern.lookForSuspiciousTransactions(trans.getValue()), temp);
					if(temp.size()>0){
						copyUniqueTransactions(temp, suspiciousTransactions);
					}
				}
			}
		}
	}

	private void copyTransactions(List<Transaction> from, List<Transaction> target){
		for(int i = 0; i<from.size(); i++){
			target.add(from.get(i));
		}
	}
	
	private void copyUniqueTransactions(List<Transaction> from, List<Transaction> target){
		for(int i = 0; i<from.size(); i++){
			if(!target.contains(from.get(i))){
				target.add(from.get(i));
			}
		}
	}
}
