package cn.study.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerDemo {
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("boming");
			}
		}, 10000, 3000);
		//第二个参数代表连环，每隔三秒执行一次

		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
