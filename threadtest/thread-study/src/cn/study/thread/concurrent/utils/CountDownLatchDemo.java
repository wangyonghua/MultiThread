package cn.study.thread.concurrent.utils;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	private static CountDownLatch countDownLatch = new CountDownLatch(1);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(new Random().nextInt(1000));
						System.out.println("等待中..." + Thread.currentThread().getName());
						countDownLatch.await();
						System.out.println("放行...");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		Thread.sleep(1000);
		System.out.println("开闸");
		countDownLatch.countDown();
	}
}
