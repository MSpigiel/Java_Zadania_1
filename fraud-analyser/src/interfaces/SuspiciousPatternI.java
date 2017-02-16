package interfaces;

import java.util.List;

import com.capgemini.analyser.Transaction;

public interface SuspiciousPatternI {

	public List<Transaction> lookForSuspiciousTransactions(List<Transaction> trans);
	
}
