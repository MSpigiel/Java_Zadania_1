package com.capgemini.analyser;

public class SuspiciousPattern {
	private int currentTransfersValue;
	private int currentTransfersCount;
	private int transfersValueLimit;
	private int transfersCountLimit;
	
	public SuspiciousPattern(int transferValueLimit, int transfersCountLimit){
		this.transfersValueLimit = transferValueLimit;
		this.transfersCountLimit = transfersCountLimit;
		currentTransfersValue = 0;
		currentTransfersCount = 0;
	}
	
//	public lookForSuspiciousTransactions
}
