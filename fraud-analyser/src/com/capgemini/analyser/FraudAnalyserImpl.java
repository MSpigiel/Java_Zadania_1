package com.capgemini.analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FraudAnalyserImpl {

	Map<Integer, Map<String, ArrayList<Transaction>>> transactionsTree = new HashMap<Integer, Map<String, ArrayList<Transaction>>>();
	List<Transaction> suspiciousTransactions;
	List<Integer> suspiciousIDs;
	
	public FraudAnalyserImpl() {
		suspiciousTransactions = new ArrayList<Transaction>();
		suspiciousIDs = new ArrayList<Integer>();
		suspiciousIDs.add(100);
		suspiciousIDs.add(105);
		
	}
	
	public void generateTransactionTree (List<Transaction> transactionList){
		for(Transaction trans : transactionList){
			if(transactionsTree.containsKey(trans.getFromUserID())){
				if(transactionsTree.get(trans.getFromUserID()).containsKey(trans.getDateIdentifier())){
					transactionsTree.get(trans.getFromUserID()).get(trans.getDateIdentifier()).add(trans);
				} else {
					transactionsTree.get(trans.getFromUserID()).put(trans.getDateIdentifier(), new ArrayList<Transaction>());
					transactionsTree.get(trans.getFromUserID()).get(trans.getDateIdentifier()).add(trans);
				}
			} else {				
				transactionsTree.put(trans.getFromUserID(), new HashMap<String, ArrayList<Transaction>>());
				transactionsTree.get(trans.getFromUserID()).put(trans.getDateIdentifier(), new ArrayList<Transaction>());
				transactionsTree.get(trans.getFromUserID()).get(trans.getDateIdentifier()).add(trans);
			}
		}
		
	}
	
	public void searchSuspiciousTransactionsByID() {
		for(int i = 0 ; i< suspiciousIDs.size() ; i++){
			if(transactionsTree.containsKey(suspiciousIDs.get(i))){
				for( Map.Entry<String, ArrayList<Transaction>> entry : transactionsTree.get(suspiciousIDs.get(i)).entrySet() ){
					for ( Transaction suspiciousTrans : entry.getValue()){
						suspiciousTransactions.add(suspiciousTrans);
					}
					
				}
			}
		}
	}
}
