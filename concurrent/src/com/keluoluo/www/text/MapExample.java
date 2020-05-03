package com.keluoluo.www.text;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MapExample {
	// private static List<Integer> list = new ArrayList<Integer>();
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	private static int threadNum = 200;
	private static int clientNum = 5000;

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore sem = new Semaphore(threadNum);
		for (int i = 0; i < clientNum; i++) {
			final int threadNum = i;
			exec.execute(() -> {
				try {
					sem.acquire();
					func(threadNum);
					sem.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		exec.shutdown();
		// list.forEach(System.out::println);
		System.out.println(map.size());
	}

	public static void func(int threadNum) {
		// list.add(threadNum);
		map.put(threadNum, threadNum);
	}
}
