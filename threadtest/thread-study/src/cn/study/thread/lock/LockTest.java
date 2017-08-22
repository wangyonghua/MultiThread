package cn.study.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private OutPrint outPrint = new OutPrint();

	public static void main(String[] args) {
		LockTest lockTest = new LockTest();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 1000; i++) {
					lockTest.outPrint.outPrinter("wangyonghua");
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 1000; i++) {
					lockTest.outPrint.outPrinter("jinyu");
				}
			}
		}).start();
	}

	class OutPrint {
		Lock lock = new ReentrantLock();

		public void outPrinter(String s) {
			char[] chars = s.toCharArray();
			lock.lock();
			for (int i = 0; i < chars.length; i++) {
				System.out.print(chars[i]);
			}
			System.out.println();
			lock.unlock();
		}
	}
}
