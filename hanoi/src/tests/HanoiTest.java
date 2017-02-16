package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.hanoi.Hanoi;

public class HanoiTest {
	Hanoi hanoi;
	@Before
    public void setUp() {
		hanoi = new Hanoi();
        hanoi.gameInitialize();
    }
	
	@Test
	public void shouldThrowNoDiskToMoveException() {
		try{
	        hanoi.towers[0].initialize(3);
	        hanoi.towers[2].putDiskOnTop(hanoi.towers[1].getUpperDisk(hanoi.towers[2]));
		} catch (Exception e) {
			System.out.println("zlapano wyjatek: " + e.getMessage());
		}
	}
	
	@Test
	public void shouldThrowWrongDiskOrderException() {
		try{
	        hanoi.towers[0].initialize(3);
	        hanoi.towers[2].putDiskOnTop(hanoi.towers[0].getUpperDisk(hanoi.towers[2]));
	        hanoi.towers[2].putDiskOnTop(hanoi.towers[0].getUpperDisk(hanoi.towers[2]));
		} catch (Exception e) {
			System.out.println("zlapano wyjatek: " + e.getMessage());
		}
	}
	
	@Test
	public void shouldCompleteGame() {
		try{
			hanoi.towers[0].initialize(3);
			hanoi.towers[2].putDiskOnTop(hanoi.towers[0].getUpperDisk(hanoi.towers[2]));
			hanoi.towers[1].putDiskOnTop(hanoi.towers[0].getUpperDisk(hanoi.towers[1]));
			hanoi.towers[1].putDiskOnTop(hanoi.towers[2].getUpperDisk(hanoi.towers[1]));
			hanoi.towers[2].putDiskOnTop(hanoi.towers[0].getUpperDisk(hanoi.towers[2]));
			hanoi.towers[0].putDiskOnTop(hanoi.towers[1].getUpperDisk(hanoi.towers[0]));
			hanoi.towers[2].putDiskOnTop(hanoi.towers[1].getUpperDisk(hanoi.towers[2]));
			hanoi.towers[2].putDiskOnTop(hanoi.towers[0].getUpperDisk(hanoi.towers[2]));
			Assert.assertEquals(3, hanoi.towers[2].getAllDisks().size());
		} catch (Exception e){
			System.out.println("zlapano wyjatek: " + e.getMessage());
		}
		
		
		
	}

}
