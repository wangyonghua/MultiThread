package cn.study.thread.concurrent.utils;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(new Random().nextInt(10000));
						System.out.println(
								"thread:" + Thread.currentThread().getName() + ",等待数目" + barrier.getNumberWaiting());
						barrier.await();
						System.out.println("开始集合...");

						Thread.sleep(new Random().nextInt(10000));
						System.out.println(
								"thread:" + Thread.currentThread().getName() + ",等待数目" + barrier.getNumberWaiting());
						barrier.await();
						System.out.println("开始结束...");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
