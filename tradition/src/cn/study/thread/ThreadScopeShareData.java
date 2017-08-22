package cn.study.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class ThreadScopeShareData {
	static Map<Thread, Integer> threadMap = new HashMap<Thread, Integer>();

	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Integer data = new Random().nextInt();
					Thread thread = Thread.currentThread();
					synchronized (ThreadScopeShareData.class) {
						threadMap.put(thread, data);
					}
					String s = thread.getName().toString() + "put data:" + data;
					System.out.println(s);
					new A().getData();
					new B().getData();
				}
			}).start();
		}
	}

	static class A {
		public void getData() {
			Integer data = threadMap.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName() + "A getData:" + data);
		}
	}

	static class B {
		public void getData() {
			Integer data = threadMap.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName() + "B getData:" + data);
		}
	}
}
