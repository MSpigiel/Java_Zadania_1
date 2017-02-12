package com.capgemini.bowling;

public class Round {
	private boolean strikeFlag;
	private boolean spareFlag;
	private int firstStrikeScore;
	private int secondStrikeScore;
	
	public Round(){
		setStrikeFlag(false);
		setSpareFlag(false);
		setFirstStrikeScore(-1);
		setSecondStrikeScore(-1);
	}

	public boolean isStrikeFlag() {
		return strikeFlag;
	}

	public void setStrikeFlag(boolean strikeFlag) {
		this.strikeFlag = strikeFlag;
	}

	public boolean isSpareFlag() {
		return spareFlag;
	}

	public void setSpareFlag(boolean spareFlag) {
		this.spareFlag = spareFlag;
	}

	public int getFirstStrikeScore() {
		return firstStrikeScore;
	}

	public void setFirstStrikeScore(int numberOfPins) {
		this.firstStrikeScore = numberOfPins;
		
	}

	public int getSecondStrikeScore() {
		return secondStrikeScore;
	}

	public void setSecondStrikeScore(int secondStrikeScore) {
		this.secondStrikeScore = secondStrikeScore;
	}

	
}
