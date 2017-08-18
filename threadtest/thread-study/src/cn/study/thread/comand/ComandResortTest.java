package cn.study.thread.comand;

public class ComandResortTest {
	public static void main(String[] args) {
		CommandResort resort = new CommandResort();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				resort.writer();
				// TODO Auto-generated method stub
			}
		});
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				resort.reader();
				// TODO Auto-generated method stub
			}
		});
	}
}
