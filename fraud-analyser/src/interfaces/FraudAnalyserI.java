package interfaces;

import java.util.List;

import com.capgemini.analyser.SuspiciousPattern;
import com.capgemini.analyser.Transaction;

public interface FraudAnalyserI {

	public void generateTransactionTree(List<Transaction> transactions);
	void searchSuspiciousTransactionsByID();
	public void searchSuspiciousTransactionsByPattern(List<SuspiciousPattern> patterns);
	
}
