package cn.study.thread.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName() + "获取锁");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						semaphore.release();
					}

				}
			}).start();
		}
	}
}
