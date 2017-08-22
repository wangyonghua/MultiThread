package cn.study.mianshi.threadcommunicate;

public class ThreadMianshi {
	public static void main(String[] args) {
		threadtest();
	}

	public static void threadtest() {
		int count = 50;
		while (count > 0) {
			System.out.println(count);
			count--;
			for (int i = 0; i < 10; i++) {
				System.out.println("main excute" + i);
			}
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 20; i++) {
						System.out.println("child thread excute" + i);
					}
				}
			});
			thread.start();
			while (thread.isAlive()) {
				Thread.yield();
			}
		}
	}
}
