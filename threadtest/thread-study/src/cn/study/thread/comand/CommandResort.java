package cn.study.thread.comand;

public class CommandResort {
	int a = 0;
	boolean flag = false;

	public void writer() {
		a = 1; // 1
		flag = true; // 2
	}

	public void reader() {
		if (flag) { // 3
			int i = a * a; // 4
			if (i == 0) {
				System.out.println(i);
			}
		}
	}
}
