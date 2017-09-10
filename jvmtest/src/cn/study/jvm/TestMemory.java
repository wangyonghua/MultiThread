package cn.study.jvm;

import java.util.ArrayList;

public class TestMemory {
	static class OOMObject {
		public byte[] placeHolder = new byte[64 * 1024 * 40];
	}

	public static void fillHeap(int num) {
		ArrayList<OOMObject> arrayList = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			arrayList.add(new OOMObject());
		}
	}

	public static void main(String[] args) {
		System.out.println("excute...");
		try {
			Thread.sleep(30000);
			fillHeap(100);
			System.gc();
			System.in.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
