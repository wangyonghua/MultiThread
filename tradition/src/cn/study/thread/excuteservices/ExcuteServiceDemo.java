package cn.study.thread.excuteservices;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExcuteServiceDemo {
	public static void main(String[] args) {
		// ExecutorService service = Executors.newFixedThreadPool(6);
		// ExecutorService service = Executors.newCachedThreadPool();
		// ExecutorService service =
		// Executors.newSingleThreadScheduledExecutor();
		// for (int i = 0; i < 10; i++) {
		// final int task = i;
		// service.execute(new Runnable() {
		//
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// for (int i = 0; i < 100; i++) {
		// System.out.println(Thread.currentThread().getName() + "loop for " + i
		// + " in " + task);
		// }
		// }
		// });
		// }
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
		service.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("booming");

			}
		}, 10, 2, TimeUnit.SECONDS);
	}
}
