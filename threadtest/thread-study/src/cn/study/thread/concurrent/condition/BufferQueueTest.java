package cn.study.thread.concurrent.condition;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferQueueTest {
	public static void main(String[] args) {
		CustomBufferQueue customBufferQueue = new BufferQueueTest().new CustomBufferQueue();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					customBufferQueue.put(new Random().nextInt(10000));
				}
			}).start();
		}

		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					customBufferQueue.get();
				}
			}).start();
		}
	}

	class CustomBufferQueue {
		private int[] array = new int[7];
		private Lock lock = new ReentrantLock();
		private Condition notFullCondition = lock.newCondition();
		private Condition notEmptyCondition = lock.newCondition();
		private int count, takeCount, putCount;

		public void put(int c) {
			try {
				lock.lock();
				while (count == array.length) {
					try {
						notFullCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (putCount == array.length)
					putCount = 0;
				array[putCount] = c;
				count++;

				System.out.println("write index:" + putCount + ",count:" + count + ",value:" + c);
				putCount++;
				this.notEmptyCondition.signal();
			} finally {
				lock.unlock();
			}
		}

		public int get() {
			lock.lock();
			int value = 0;
			try {
				while (count == 0) {
					try {
						this.notEmptyCondition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (takeCount == array.length) {
					takeCount = 0;
				}

				value = array[takeCount];
				count--;
				System.out.println("get index:" + takeCount + ",count:" + count + ",value:" + value);
				takeCount++;
				this.notFullCondition.signal();
				return value;
			} finally {
				lock.unlock();
			}

		}
	}

}
