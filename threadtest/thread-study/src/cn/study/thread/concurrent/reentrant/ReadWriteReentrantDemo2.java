package cn.study.thread.concurrent.reentrant;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteReentrantDemo2 {

	private int data = 0;
	private Cache cache = new Cache();

	public static void main(String[] args) {
		ReadWriteReentrantDemo2 demo = new ReadWriteReentrantDemo2();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 0; j < 100; j++) {
						demo.cache.getData();
					}
				}
			}).start();
		}

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 0; j < 100; j++) {
						demo.cache.setData();
					}
					demo.cache.setData();
				}
			}).start();
		}
	}

	class Cache {
		private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		public int getData() {
			try {
				lock.readLock().lock();
				System.out.println("读data...");
				return data;
			} finally {
				// TODO: handle finally clause
				System.out.println("读取data完毕");
				lock.readLock().unlock();
			}
		}

		public void setData() {
			try {
				lock.writeLock().lock();
				System.out.println("写data...");
				data = new Random().nextInt(1000);
			} finally {
				// TODO: handle finally clause
				System.out.println("写data完毕");
				lock.writeLock().unlock();
			}
		}
	}
}
