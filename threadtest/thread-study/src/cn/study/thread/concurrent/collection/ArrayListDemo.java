package cn.study.thread.concurrent.collection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
		arrayList.add("张三");
		arrayList.add("李四");
		arrayList.add("王五");

		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			String s = (String) iterator.next();
			boolean s1 = s.equalsIgnoreCase("张三");
			if (s1) {
				arrayList.remove(s);
			}
		}
		System.out.println("ok");
	}
}
