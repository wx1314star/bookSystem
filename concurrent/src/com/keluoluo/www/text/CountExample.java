package com.keluoluo.www.text;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 并发模拟测试
 * 
 * @author wx
 *
 *         Aug 15, 2019
 */

public class CountExample {

	// 每次执行
	private static int threadTotal = 1;
	// 总请求
	private static int clientTotal = 5000;

	private static long count = 0;

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		for (int i = 0; i < clientTotal; i++) {
			exec.execute(() -> {
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		exec.shutdown();
		System.out.println("count:" + count);
	}

	private static void add() {
		count++;
	}

}
