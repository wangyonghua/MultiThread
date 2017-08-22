package cn.study.thread;

public class TraditionThreadDemo {
	public static void main(String[] args) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("1:" + this.getName());
			}
		};

		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("2:" + Thread.currentThread().getName());

			}
		});

		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("3:" + Thread.currentThread().getName());

			}
		}) {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("4:" + Thread.currentThread().getName());
			}
		};

		thread.start();
		thread2.start();
		thread3.start();
		System.out.println("okay");

	}
}
