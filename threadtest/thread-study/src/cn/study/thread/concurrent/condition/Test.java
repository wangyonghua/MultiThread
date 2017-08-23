package cn.study.thread.concurrent.condition;

public class Test {
	public static void main(String[] args) {
		int count = -2;
		for (int i = -3; i < 10; i++) {
			boolean b = i < 0;
			System.out.println(b);
			System.out.println(i);
		}
		count = get();
		count = get1();
		System.out.println(count);
	}

	public static int get() {
		System.out.println("1");
		int count = 1;
		count = count--;
		return get1();
	}

	public static int get1() {
		return 2;
	}
}
