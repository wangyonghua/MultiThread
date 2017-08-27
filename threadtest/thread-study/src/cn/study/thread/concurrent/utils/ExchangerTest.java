package cn.study.thread.concurrent.utils;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();

		new Thread(new Runnable() {
			@Override
			public void run() {
				String data = "wang";
				try {
					Thread.sleep(new Random().nextInt(10000));
					System.out.println(Thread.currentThread().getName() + "进入" + data);
					String data2 = exchanger.exchange(data);
					System.out.println(data2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				String data = "hua";
				try {
					System.out.println(Thread.currentThread().getName() + "进入" + data);
					Thread.sleep(new Random().nextInt(10000));
					String data2 = exchanger.exchange(data);
					System.out.println(data2 + "," + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
	}

}
