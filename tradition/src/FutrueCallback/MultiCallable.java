package FutrueCallback;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPool);
		for (int i = 0; i < 10; i++) {
			final int task = i;
			completionService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					return task;
				}
			});
		}

		for (int i = 0; i < 10; i++) {
			Integer integer = completionService.take().get();
			System.out.println(integer);
		}

		threadPool.shutdown();
	}
}
