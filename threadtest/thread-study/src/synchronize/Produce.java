package synchronize;

public class Produce {
	public void start() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			synchronized (SynchronizeTest.obj) {
				System.out.println("B");
				SynchronizeTest.obj.notify();
				SynchronizeTest.obj.wait();
			}
		}
	}
}
