package cn.study.mianshi.threadcommunicate;

public class Bussiness {
	public boolean isSub = true;

	public synchronized void main(int n) {
		while (isSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 100; i++) {
			System.out.println("main loop " + i + "in " + n);
		}
		isSub = true;
		this.notify();
	}

	public synchronized void sub(int n) {
		while (!isSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("sub loop " + i + "in " + n);
		}
		isSub = false;
		this.notify();
	}
}
