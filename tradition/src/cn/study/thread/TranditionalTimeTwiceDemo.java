package cn.study.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TranditionalTimeTwiceDemo {
	public static int count = 0;

	// public class TimeTask1 extends TimerTask {
	//
	// @Override
	// public void run() {
	// System.out.println("booming");
	// new Timer().schedule(new TimeTask2(), 4000);
	//
	// }
	//
	// }

	public static void main(String[] args) {
		class TimeTask2 extends TimerTask {

			@Override
			public void run() {
				count = (count + 1) % 2;
				System.out.println("booming");
				new Timer().schedule(new TimeTask2(), 2000 + 2000 * count);

			}

		}
		// TimeTask1 t1 = new TranditionalTimeTwiceDemo().new TimeTask1();
		// new Timer().schedule(t1, 2000);
		new Timer().schedule(new TimeTask2(), 2000);
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
