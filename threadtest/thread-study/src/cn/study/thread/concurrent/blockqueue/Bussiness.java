package cn.study.thread.concurrent.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bussiness {
	Lock lock = new ReentrantLock();
	ArrayBlockingQueue<Integer> mainArrayBlockingQueue = new ArrayBlockingQueue<>(1);
	ArrayBlockingQueue<Integer> SubArrayBlockingQueue = new ArrayBlockingQueue<>(1);

	{
		try {
			SubArrayBlockingQueue.put(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void main(int n) {
		try {
			mainArrayBlockingQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 100; i++) {
			System.out.println("main loop " + i + "in " + n);
		}
		try {
			SubArrayBlockingQueue.put(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sub(int n) {
		try {
			SubArrayBlockingQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("sub loop " + i + "in " + n);
		}
		try {
			mainArrayBlockingQueue.put(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
