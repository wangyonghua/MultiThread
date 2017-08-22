package cn.study.thread.concurrent.reentrant;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteReentrantDemo {

	private int data = 0;
	private Cache cache = new Cache();

	public static void main(String[] args) {
		ReadWriteReentrantDemo demo = new ReadWriteReentrantDemo();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(demo.cache.getData(""));
				}
			}).start();
		}
	}

	class Cache {
		private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		public int getData(String key) {
			try {
				lock.readLock().lock();
				System.out.println("正在读取data...");
				if (data <= 0) {
					try {
						lock.readLock().unlock();
						lock.writeLock().lock();
						System.out.println("正在写data...");
						if (data <= 0) {
							data = generateData();
						}
						lock.readLock().lock();
					} finally {
						// TODO: handle finally clause
						System.out.println("正在写data结束...");
						lock.writeLock().unlock();
					}
				}

			} finally {
				// TODO: handle finally clause
				System.out.println("读取data完毕");
				lock.readLock().unlock();
			}
			return data;
		}

		public int generateData() {
			return new Random().nextInt(1000);
		}
	}
}
