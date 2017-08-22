package cn.study.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class ThreadLocalTest {
	static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Integer data = new Random().nextInt();
					x.set(data);
					new A().getData();
					new B().getData();
				}
			}).start();
		}
	}

	static class A {
		public void getData() {
			Integer data = x.get();
			System.out.println(Thread.currentThread().getName() + "A getData:" + data);
		}
	}

	static class B {
		public void getData() {
			Integer data = x.get();
			System.out.println(Thread.currentThread().getName() + "B getData:" + data);
		}
	}
}
