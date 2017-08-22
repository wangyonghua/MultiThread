package synchronize;

public class Consumer {
	public void start() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			synchronized (SynchronizeTest.obj) {
				System.out.println("A");
			    SynchronizeTest.obj.notify();
				SynchronizeTest.obj.wait();
			}
		}
	}
}
