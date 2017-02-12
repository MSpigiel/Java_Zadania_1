package com.capgemini.hanoi;

import java.util.LinkedList;
import java.util.List;
//stos
public class Tower {
	private List<Disk> disks;
	private boolean gameFinished;

	public Tower() {
		disks = new LinkedList<Disk>();
		setGameFinished(false);
	}

	public void initialize(int numberOfDisks) {
		if (!disks.isEmpty()) {

		} else {
			for (int i = 0; i < numberOfDisks; i++) {
				disks.add(new Disk(numberOfDisks - i));
			}
		}

	}

	public List<Disk> getAllDisks() {
		return disks;
	}

	public int getUpperDiskSize() {
		if (disks.size() < 1) {
			return 0;
		} else {
			return (disks.get(disks.size() - 1)).getDiskSize();
		}

	}

	public Disk getUpperDisk(Tower targetTower) throws NoDiskToMoveException, WrongDiskOrderException {

		if (disks.size() == 0) {
			throw new NoDiskToMoveException("Brak dysku do przeniesienia");

		} else if (targetTower.getUpperDiskSize() == 0) {
			Disk temp = disks.get(disks.size() - 1);
			disks.remove(disks.size() - 1);
			return temp;

		} else if (targetTower.getUpperDiskSize() < disks.get(disks.size() - 1).getDiskSize()) {
			throw new WrongDiskOrderException("Nie mozna przesunac wiekszego krazka na mniejszy");
		} else {
			Disk temp = disks.get(disks.size() - 1);
			disks.remove(disks.size() - 1);
			return temp;
		}

	}

	public void putDiskOnTop(Disk disk) {
		if (disks.size() < 1) {
			disks.add(disk);
			return;
		}

		if (disks.size() > 0 && disks.get(disks.size() - 1).getDiskSize() < disk.getDiskSize()) {
			System.out.println("hello");
		} else {
			disks.add(disk);
		}
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}
}
