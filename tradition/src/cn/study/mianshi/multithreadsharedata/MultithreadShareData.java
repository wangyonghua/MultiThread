package cn.study.mianshi.multithreadsharedata;

import java.util.Iterator;

public class MultithreadShareData {
	private int j = 0;

	public static void main(String[] args) {
		MultithreadShareData tt = new MultithreadShareData();
		for (int i = 0; i < 2; i++) {
			new Thread(tt.new IncRunnable()).start();
			new Thread(tt.new DecRunnable()).start();
		}
	}

	public synchronized void inc() {
		j++;
		System.out.println(Thread.currentThread().getName() + ",j=" + j);
	}

	public synchronized void dec() {
		j--;
		System.out.println(Thread.currentThread().getName() + ",j=" + j);
	}

	class IncRunnable implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 100; i++) {
				inc();
			}
		}
	}

	class DecRunnable implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 100; i++) {
				dec();
			}
		}
	}

}
