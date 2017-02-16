package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.analyser.FraudAnalyserImpl;
import com.capgemini.analyser.SuspiciousPattern;
import com.capgemini.analyser.Transaction;


public class FraudAnalyserTest {

	FraudAnalyserImpl analyser;
	List<Transaction> allTransactions;
	List<SuspiciousPattern> patterns;;

	@Before
	public void setUp() {
		analyser = new FraudAnalyserImpl();
		allTransactions = new ArrayList<Transaction>();
		patterns = new ArrayList<SuspiciousPattern>();
	}

	@Test
	public void shouldReturnSixTransactionsAsIllegalByOver5TransactionsPattern() {
		// given
		SuspiciousPattern p1 = new SuspiciousPattern(5);
		patterns.add(p1);
		
		
		Transaction t1 = new Transaction(1234, 4321, 100);
		Transaction t2 = new Transaction(1234, 4567, 200);
		Transaction t3 = new Transaction(1234, 2222, 500);
		Transaction t4 = new Transaction(1234, 1231, 500);
		Transaction t5 = new Transaction(1234, 1122, 200);
		Transaction t6 = new Transaction(1234, 434, 3020);
		Transaction t7 = new Transaction(1235, 43241, 3040);
		Transaction t8 = new Transaction(1236, 43554, 3001);
		Transaction t9 = new Transaction(1237, 43124, 3020);
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		allTransactions.add(t4);
		allTransactions.add(t5);
		allTransactions.add(t6);
		allTransactions.add(t7);
		allTransactions.add(t8);
		allTransactions.add(t9);
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByPattern(patterns);
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(6, suspTransactions);	
	}
	
	@Test
	public void shouldNotReturnAnyTransactionsAsIllegalByOver5TransactionsPattern() {
		// given
		SuspiciousPattern p1 = new SuspiciousPattern(5);
		patterns.add(p1);
		
		
		Transaction t1 = new Transaction(1234, 4321, 100);
		Transaction t2 = new Transaction(1234, 4567, 200);
		Transaction t3 = new Transaction(1234, 2222, 500);
		Transaction t4 = new Transaction(1234, 1231, 500);
		Transaction t5 = new Transaction(1234, 1122, 200);
		Transaction t7 = new Transaction(1235, 43241, 3040);
		Transaction t8 = new Transaction(1236, 43554, 3001);
		Transaction t9 = new Transaction(1237, 43124, 3020);
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		allTransactions.add(t4);
		allTransactions.add(t5);
		allTransactions.add(t7);
		allTransactions.add(t8);
		allTransactions.add(t9);
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByPattern(patterns);
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(0, suspTransactions);
		
	}
	
	@Test
	public void shouldReturnAllTransactionsOfSuspicousID() {
		// given
		
		
		Transaction t1 = new Transaction(542, 4321, 100);
		Transaction t2 = new Transaction(542, 4567, 20);
		Transaction t3 = new Transaction(542, 2222, 500);
		Transaction t4 = new Transaction(542, 1231, 50);
		Transaction t5 = new Transaction(1234, 1122, 200);
		Transaction t6 = new Transaction(1234, 434, 3020);
		Transaction t7 = new Transaction(1235, 43241, 3040);
		Transaction t8 = new Transaction(1236, 43554, 3001);
		Transaction t9 = new Transaction(1237, 43124, 3020);
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		allTransactions.add(t4);
		allTransactions.add(t5);
		allTransactions.add(t6);
		allTransactions.add(t7);
		allTransactions.add(t8);
		allTransactions.add(t9);
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByID();
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(4, suspTransactions);	
	}
	
	@Test
	public void shouldNotReturnAnyTransactionsOfWhiteID() {
		// given
		SuspiciousPattern p1 = new SuspiciousPattern(5);
		p1.setMaxTransfersToOneId(2);
		patterns.add(p1);
		
		Transaction t1 = new Transaction(101, 4321, 100);
		Transaction t2 = new Transaction(101, 4567, 20);
		Transaction t3 = new Transaction(101, 2222, 500);
		Transaction t4 = new Transaction(101, 1231, 5550);
		Transaction t5 = new Transaction(101, 1211, 50000);
		Transaction t6 = new Transaction(101, 1531, 50);
		Transaction t7 = new Transaction(101, 1231, 510);
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		allTransactions.add(t4);
		allTransactions.add(t5);
		allTransactions.add(t6);
		allTransactions.add(t7);
		
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByPattern(patterns);
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(0, suspTransactions);	
	}
	
	@Test
	public void shouldReturnAllTransactionsOfIdThatDidMoreThan4TransfersToOneIdPattern() {
		// given
		SuspiciousPattern p1 = new SuspiciousPattern(5);
		p1.setMaxTransfersToOneId(4);
		patterns.add(p1);
		
		Transaction t1 = new Transaction(1101, 4321, 100);
		Transaction t2 = new Transaction(1101, 4321, 20);
		Transaction t3 = new Transaction(1101, 4321, 500);
		Transaction t4 = new Transaction(1101, 4321, 5550);
		Transaction t5 = new Transaction(1101, 4321, 50000);
		Transaction t6 = new Transaction(1201, 1531, 50);
		Transaction t7 = new Transaction(1301, 1231, 510);
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		allTransactions.add(t4);
		allTransactions.add(t5);
		allTransactions.add(t6);
		allTransactions.add(t7);
		
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByPattern(patterns);
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(5, suspTransactions);	
	}
	
	@Test
	public void shouldReturnAllTransactionsOfIdThatDidMoreThan3TransfersForOver5000Pattern() {
		// given
		SuspiciousPattern p1 = new SuspiciousPattern(3);
		p1.setTransfersValueLimit(5000);
		patterns.add(p1);
		
		Transaction t1 = new Transaction(1101, 4321, 1000);
		Transaction t2 = new Transaction(1101, 4321, 2000);
		Transaction t3 = new Transaction(1101, 4321, 1000);
		Transaction t4 = new Transaction(1101, 4321, 1001);
		
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		allTransactions.add(t4);
		
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByPattern(patterns);
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(4, suspTransactions);	
	}
	
	@Test
	public void shouldReturnNoTransactionsOfIdThatDidMoreThan3TransfersForOver5000Pattern() {
		// given
		SuspiciousPattern p1 = new SuspiciousPattern(3);
		p1.setTransfersValueLimit(5000);
		patterns.add(p1);
		
		Transaction t1 = new Transaction(1101, 4321, 1000);
		Transaction t2 = new Transaction(1101, 4321, 2000);
		Transaction t3 = new Transaction(1101, 4321, 1000);
		Transaction t4 = new Transaction(1101, 4321, 1000);
		
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		allTransactions.add(t4);
		
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByPattern(patterns);
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(0, suspTransactions);	
	}
	
	@Test
	public void shouldReturnAllTransactionsOfIdThatDidMoreThan2TransfersForOver10000() {
		// given
		SuspiciousPattern p1 = new SuspiciousPattern(2);
		p1.setTransfersValueLimit(10000);
		patterns.add(p1);
		
		Transaction t1 = new Transaction(1101, 4321, 1000);
		Transaction t2 = new Transaction(1101, 4321, 2000);
		Transaction t3 = new Transaction(1101, 4321, 7001);
		
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByPattern(patterns);
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(3, suspTransactions);	
	}
	
	@Test
	public void shouldReturnNoTransactionsOfIdThatDidMoreThan2TransfersForOver10000() {
		// given
		SuspiciousPattern p1 = new SuspiciousPattern(2);
		p1.setTransfersValueLimit(10000);
		patterns.add(p1);
		
		Transaction t1 = new Transaction(1101, 4321, 1000);
		Transaction t2 = new Transaction(1101, 4321, 2000);
		Transaction t3 = new Transaction(1101, 4321, 7000);
		
		
		allTransactions.add(t1);
		allTransactions.add(t2);
		allTransactions.add(t3);
		
		analyser.generateTransactionTree(allTransactions);
		analyser.searchSuspiciousTransactionsByPattern(patterns);
		// when
		int suspTransactions = analyser.suspiciousTransactions.size();
		// then
		Assert.assertEquals(0, suspTransactions);	
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenWrongTransferValue() {
		// given
		try{
			Transaction t1 = new Transaction(1101, 4321, -1000);
			allTransactions.add(t1);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
