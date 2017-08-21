package FutrueCallback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javafx.util.Callback;

public class FutrueDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Future<String> result = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "hello";
			}
		});
		try {
			String res = result.get();
			System.out.println(res);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
