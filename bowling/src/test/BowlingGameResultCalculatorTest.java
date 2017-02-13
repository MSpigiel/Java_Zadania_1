package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.bowling.BowlingGameResultCalculatorImpl;

public class BowlingGameResultCalculatorTest {

	BowlingGameResultCalculatorImpl calculator;

	@Before
	public void setUp() {
		calculator = new BowlingGameResultCalculatorImpl();
	}

	@Test
	public void isStrikeFlagInFirstRoundSet() {
		// given
		calculator.roll(10);
		// when
		boolean isStrike = calculator.rounds.get(0).isStrikeFlag();
		// then
		Assert.assertTrue(isStrike);
	}

	@Test
	public void spareFlagInFirstRoundShouldNotBeSet() {
		// given
		calculator.roll(10);
		// when
		boolean isSpare = calculator.rounds.get(0).isSpareFlag();
		// then
		Assert.assertFalse(isSpare);
	}
	
	@Test
	public void isScoreAfterFirstRoundCorrect() {
		// given
		calculator.roll(2);
		calculator.roll(8);
		// when
		int result = calculator.getCombinedScore();
		// then
		Assert.assertEquals(10, result);
	}
	
	@Test
	public void isScoreAfterTwoRoundsCorrect() {
		// given
		calculator.roll(1);
		calculator.roll(9);
		calculator.roll(0);
		calculator.roll(3);
		// when
		int result = calculator.getCombinedScore();
		// then
		Assert.assertEquals(13, result);
	}
	
	@Test
	public void isScoreAfterEightRoundsCorrect() {
		// given
		calculator.roll(10);
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(5);
		calculator.roll(5);
		calculator.roll(7);
		calculator.roll(2);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(9);
		// when
		int result = calculator.getCombinedScore();
		// then
		Assert.assertEquals(148, result);
	}

}
