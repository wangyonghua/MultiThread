package cn.study.thread.concurrent.condition;

public class ConditionDemo {
	public static void main(String[] args) {
		final Bussiness buss = new Bussiness();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 50; i++) {
					buss.sub(i);
				}
			}
		}).start();
		for (int i = 0; i < 50; i++) {
			buss.main(i);
		}
	}
}
