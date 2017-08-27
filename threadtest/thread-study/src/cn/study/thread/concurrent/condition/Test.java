package cn.study.thread.concurrent.condition;

public class Test {
	public static void main(String[] args) {
		int count = 1;
		count = count - 1;
		for (int i = -5; i < 5; i++) {
			boolean b = i < 0;
			System.out.println(b);
		}
	}
}
