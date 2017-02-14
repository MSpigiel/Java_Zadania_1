package com.capgemini.analyser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private DateTimeFormatter formatter;
	private int fromUserID;
	private int toUserID;
	private int transferAmount;
	private LocalDateTime transferDate;

	public Transaction(int fromID, int toID, int amount) {
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		setFromUserID(fromID);
		setToUserID(toID);
		setTransferAmount(amount);
		setTransferDate(LocalDateTime.now());
	}

	public String getDateIdentifier() {
		String formattedDateTime = transferDate.format(formatter);
		return formattedDateTime;
	}

	public int getFromUserID() {
		return fromUserID;
	}

	public void setFromUserID(int fromUserID) {
		this.fromUserID = fromUserID;
	}

	public int getToUserID() {
		return toUserID;
	}

	public void setToUserID(int toUserID) {
		this.toUserID = toUserID;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public LocalDateTime getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDateTime transferDate) {
		this.transferDate = transferDate;
	}

}
