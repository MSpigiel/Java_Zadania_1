package com.capgemini.hanoi;

public class Disk {
	private int diskSize;
	public Disk(int diskSize){
		this.diskSize = diskSize;
	}
	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}
}
