package com.capgemini.hanoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hanoi {
	public Tower[] towers;
	private int moves = 0;
	private int decision;
	Scanner reader;

	public void move(Tower sourceTower, Tower targetTower) {
		try {
			targetTower.putDiskOnTop(sourceTower.getUpperDisk(targetTower));
		} catch (Exception e) {
			System.out.println("zlapano wyjatek: " + e.getMessage());
		}

	}

	public void gameInitialize() {
		towers = new Tower[3];
		reader = new Scanner(System.in);
		towers[0] = new Tower();
		towers[1] = new Tower();
		towers[2] = new Tower();
	}

	public void play() {
		System.out.println("Podaj z iloma krazkami chcesz rozpoczac gre");
		int disksNumber = Integer.parseInt(reader.nextLine());
		towers[0].initialize(disksNumber);

		while (!towers[2].isGameFinished()) {
			System.out.println("Wieza 1");
			for (int i = 0; i < towers[0].getAllDisks().size(); i++) {
				System.out.print(towers[0].getAllDisks().get(i).getDiskSize() + " ");
			}
			System.out.println();
			System.out.println("Wieza 2");
			for (int i = 0; i < towers[1].getAllDisks().size(); i++) {
				System.out.print(towers[1].getAllDisks().get(i).getDiskSize() + " ");
			}
			System.out.println();
			System.out.println("Wieza 3");
			for (int i = 0; i < towers[2].getAllDisks().size(); i++) {
				System.out.print(towers[2].getAllDisks().get(i).getDiskSize() + " ");
			}
			System.out.println();

			if (towers[2].getAllDisks().size() == disksNumber) {
				System.out.println("Gratulacje, wygrales!" + " Ilosc ruchow: " + moves);
				break;
			}

			System.out.println("Lista mozliwych do wykonania ruchow:");
			System.out.println("1 - (1->2)");
			System.out.println("2 - (1->3)");
			System.out.println("3 - (2->3)");
			System.out.println("4 - (2->1)");
			System.out.println("5 - (3->1)");
			System.out.println("6 - (3->2)");

			decision = Integer.parseInt(reader.nextLine());

			switch (decision) {
			case 1:
				move(towers[0], towers[1]);
				break;
			case 2:
				move(towers[0], towers[2]);
				break;
			case 3:
				move(towers[1], towers[2]);
				break;
			case 4:
				move(towers[1], towers[0]);
				break;
			case 5:
				move(towers[2], towers[0]);
				break;
			case 6:
				move(towers[2], towers[1]);
				break;
			}
			moves++;
		}
	}
}
