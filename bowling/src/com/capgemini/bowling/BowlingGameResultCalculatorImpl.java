package com.capgemini.bowling;

import java.util.ArrayList;
import java.util.List;

import interfaces.BowlingGameResultCalculator;

public class BowlingGameResultCalculatorImpl implements BowlingGameResultCalculator {

	private int combinedScore;
	private int currentRound = 1;
	public List<Round> rounds;

	public BowlingGameResultCalculatorImpl() {
		rounds = new ArrayList<Round>();
		for (int i = 0; i < 10; i++) {
			rounds.add(new Round());
		}

	}

	@Override
	public void roll(int numberOfPins) {

		if (numberOfPins < 0 || numberOfPins > 10) {
			throw new IllegalStateException();
		} else {
			switch (currentRound) {
			case 1:
				firstRoundRoll(numberOfPins);
				break;
			case 2:
				secondRoundRoll(numberOfPins);
				break;
			case 3:
				regularRoundRoll(numberOfPins);
				break;
			case 4:
				regularRoundRoll(numberOfPins);
				break;
			case 5:
				regularRoundRoll(numberOfPins);
				break;
			case 6:
				regularRoundRoll(numberOfPins);
				break;
			case 7:
				regularRoundRoll(numberOfPins);
				break;
			case 8:
				regularRoundRoll(numberOfPins);
				break;
			case 9:
				regularRoundRoll(numberOfPins);
				break;
			case 10:
				lastRoundRoll(numberOfPins);
				break;

			}

		}

	}

	@Override
	public int score() {

		return 0;
	}

	@Override
	public boolean isFinished() {

		return false;
	}

	private void firstRoundRoll(int numberOfPins) {
		// sprawdzamy czy obecny rzut to pierwszy czy drugi w turze
		if (rounds.get(currentRound - 1).getFirstStrikeScore() == -1) {
			// sprawdzamy czy wyrzucono max
			if (numberOfPins == 10) {
				rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
				rounds.get(currentRound - 1).setStrikeFlag(true);
				combinedScore += numberOfPins;
				currentRound++;
			} else {
				rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
				combinedScore += numberOfPins;
			} // drugi rzut w kolejce
		} else if (rounds.get(currentRound - 1).getSecondStrikeScore() == -1) {
			// sprawdzamy czy suma zbitych kregli w 1 i 2 rzucie danej tury
			// nie przekracza max wartosci
			if (rounds.get(currentRound - 1).getFirstStrikeScore() + numberOfPins < 11) {
				// sprawdzamy czy w drugim rzucie zbito wszystkie kregle
				if (rounds.get(currentRound - 1).getFirstStrikeScore() + numberOfPins == 10) {
					rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
					rounds.get(currentRound - 1).setSpareFlag(true);
					combinedScore += numberOfPins;
					currentRound++;
				} else {
					combinedScore += numberOfPins;
					currentRound++;
				}
			} else {
				throw new IllegalStateException();
			}
		}

	}

	private void secondRoundRoll(int numberOfPins) {
		if (rounds.get(currentRound - 1).getFirstStrikeScore() == -1) {
			if (numberOfPins == 10) {
				if (rounds.get(currentRound - 2).isStrikeFlag() || rounds.get(currentRound - 2).isSpareFlag()) {
					rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
					rounds.get(currentRound - 1).setStrikeFlag(true);
					combinedScore += numberOfPins * 2;
					currentRound++;
				} else {
					rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
					rounds.get(currentRound - 1).setStrikeFlag(true);
					combinedScore += numberOfPins;
					currentRound++;
				}
			} else {
				if (rounds.get(currentRound - 2).isStrikeFlag() || rounds.get(currentRound - 2).isSpareFlag()) {
					rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
					combinedScore += numberOfPins * 2;
				} else {
					rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
					combinedScore += numberOfPins;
				}
			}
		} else if (rounds.get(currentRound - 1).getSecondStrikeScore() == -1) {
			if (rounds.get(currentRound - 1).getFirstStrikeScore() + numberOfPins < 11) {
				if (rounds.get(currentRound - 1).getFirstStrikeScore() + numberOfPins == 10) {
					if (rounds.get(currentRound - 2).isStrikeFlag()) {
						rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
						rounds.get(currentRound - 1).setSpareFlag(true);
						combinedScore += numberOfPins * 2;
						currentRound++;
					} else {
						rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
						rounds.get(currentRound - 1).setSpareFlag(true);
						combinedScore += numberOfPins;
						currentRound++;
					}
				} else {
					if (rounds.get(currentRound - 2).isStrikeFlag()) {
						rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
						combinedScore += numberOfPins * 2;
						currentRound++;
					} else {
						rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
						combinedScore += numberOfPins;
						currentRound++;
					}
				}
			}
		}
	}

	private void lastRoundRoll(int numberOfPins) {

	}

	private void regularRoundRoll(int numberOfPins) {
		if (rounds.get(currentRound - 1).getFirstStrikeScore() == -1) {
			if (numberOfPins == 10) {
				if (rounds.get(currentRound - 2).isStrikeFlag() || rounds.get(currentRound - 2).isSpareFlag()) {
					rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
					rounds.get(currentRound - 1).setStrikeFlag(true);
					combinedScore += numberOfPins * 2;
					currentRound++;
				} else {
					rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
					rounds.get(currentRound - 1).setStrikeFlag(true);
					combinedScore += numberOfPins;
					currentRound++;
				}
			} else {
				if (rounds.get(currentRound - 2).isStrikeFlag() || rounds.get(currentRound - 2).isSpareFlag()) {
					rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
					combinedScore += numberOfPins * 2;
				} else {
					rounds.get(currentRound - 1).setFirstStrikeScore(numberOfPins);
					combinedScore += numberOfPins;
				}
			}
		} else if (rounds.get(currentRound - 1).getSecondStrikeScore() == -1) {
			if (rounds.get(currentRound - 1).getFirstStrikeScore() + numberOfPins < 11) {
				if (rounds.get(currentRound - 1).getFirstStrikeScore() + numberOfPins == 10) {
					if (rounds.get(currentRound - 2).isStrikeFlag()) {
						rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
						rounds.get(currentRound - 1).setSpareFlag(true);
						combinedScore += numberOfPins * 2;
						currentRound++;
					} else {
						rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
						rounds.get(currentRound - 1).setSpareFlag(true);
						combinedScore += numberOfPins;
						currentRound++;
					}
				} else {
					if (rounds.get(currentRound - 2).isStrikeFlag()) {
						rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
						combinedScore += numberOfPins * 2;
						currentRound++;
					} else {
						rounds.get(currentRound - 1).setSecondStrikeScore(numberOfPins);
						combinedScore += numberOfPins;
						currentRound++;
					}
				}
			}
		}
	}

	public int getCombinedScore() {
		return combinedScore;
	}

}
