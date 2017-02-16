package com.capgemini.analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuspiciousPattern {

	private int currentTransfersValue;
	private int currentTransfersCount;
	private int transfersValueLimit;
	private int transfersCountLimit;
	private int maxTransfersToOneId;
	private HashMap<Integer, Integer> targetIDs;

	public SuspiciousPattern(int transfersCountLimit) {
		targetIDs = new HashMap<Integer, Integer>();
		this.setTransfersCountLimit(transfersCountLimit);
		setTransfersValueLimit(0);
		setCurrentTransfersValue(0);
		setCurrentTransfersCount(0);
		setMaxTransfersToOneId(0);
	}

	public List<Transaction> lookForSuspiciousTransactions(List<Transaction> trans) {

		summerizeTransfersValue(trans);
		summerizeTransfersCount(trans);

		if (maxTransfersToOneId > 0) {
			generateMostCommonTargetIds(trans);
			if (getNumberOfMostCommonTransfersToOneId() > maxTransfersToOneId) {
				currentTransfersCount = 0;
				currentTransfersValue = 0;
				targetIDs.clear();
				return trans;
			}
			targetIDs.clear();
		}

		if (transfersValueLimit > 0) {
			if (currentTransfersValue > transfersValueLimit && currentTransfersCount > transfersCountLimit) {
				currentTransfersCount = 0;
				currentTransfersValue = 0;
				return trans;
			}
		} else if (transfersCountLimit > 0) {
			if (currentTransfersCount > transfersCountLimit) {
				currentTransfersCount = 0;
				currentTransfersValue = 0;
				return trans;
			}
		}

		currentTransfersCount = 0;
		currentTransfersValue = 0;
		List<Transaction> a = new ArrayList<Transaction>();
		return a;
	}

	public int getCurrentTransfersValue() {
		return currentTransfersValue;
	}

	public void setCurrentTransfersValue(int currentTransfersValue) {
		this.currentTransfersValue = currentTransfersValue;
	}

	public int getCurrentTransfersCount() {
		return currentTransfersCount;
	}

	public void setCurrentTransfersCount(int currentTransfersCount) {
		this.currentTransfersCount = currentTransfersCount;
	}

	public int getTransfersValueLimit() {
		return transfersValueLimit;
	}

	public void setTransfersValueLimit(int transfersValueLimit) {
		this.transfersValueLimit = transfersValueLimit;
	}

	public int getTransfersCountLimit() {
		return transfersCountLimit;
	}

	public void setTransfersCountLimit(int transfersCountLimit) {
		this.transfersCountLimit = transfersCountLimit;
	}

	public int getMaxTransfersToOneId() {
		return maxTransfersToOneId;
	}

	public void setMaxTransfersToOneId(int maxTransfersToOneId) {
		this.maxTransfersToOneId = maxTransfersToOneId;
	}
	
	private void summerizeTransfersValue(List<Transaction> transactions) {
		for (Transaction trans : transactions) {
			currentTransfersValue += trans.getTransferAmount();
		}
	}

	private void summerizeTransfersCount(List<Transaction> transactions) {
		for (Transaction trans : transactions) {
			currentTransfersCount++;
		}
	}

	private void generateMostCommonTargetIds(List<Transaction> transactions) {
		for (Transaction trans : transactions) {
			if (targetIDs.containsKey(trans.getToUserID())) {
				targetIDs.put(trans.getToUserID(), targetIDs.get(trans.getToUserID()) + 1);
			} else {
				targetIDs.put(trans.getToUserID(), 1);
			}
		}

	}

	private int getNumberOfMostCommonTransfersToOneId() {
		int maxTransfers = 0;
		for (Map.Entry<Integer, Integer> entry : targetIDs.entrySet()) {
			if (maxTransfers < entry.getValue()) {
				maxTransfers = entry.getValue();
			}
		}
		return maxTransfers;
	}

}
