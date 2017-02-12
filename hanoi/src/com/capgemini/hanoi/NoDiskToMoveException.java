package com.capgemini.hanoi;

public class NoDiskToMoveException extends Exception {
	public  NoDiskToMoveException() {
		super();
	}
	public  NoDiskToMoveException(String message) {
		super(message);
	}
}
