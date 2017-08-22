package cn.study.thread.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bussiness {
	public boolean isSub = true;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void main(int n) {
		lock.lock();
		try {
			while (isSub) {
				try {
					condition.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 100; i++) {
				System.out.println("main loop " + i + "in " + n);
			}
			isSub = true;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

	public void sub(int n) {
		lock.lock();
		try {
			while (!isSub) {
				try {
					condition.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 10; i++) {
				System.out.println("sub loop " + i + "in " + n);
			}
			isSub = false;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}
