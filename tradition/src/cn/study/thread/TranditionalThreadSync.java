package cn.study.thread;

public class TranditionalThreadSync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					outPrint("wangyonghuawangyonghuawangyonghuawangyonghua");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					outPrint("jinyujinyujinyujinyu");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public static void outPrint(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}
		System.out.println();
	}
}
