package com.keluoluo.www.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedExample2 {
	/**
	 * 修饰一个类,同一时间只有一个线程执行
	 */
	public static void test1(int j) {
		synchronized (SynchronizedExample2.class) {
			for (int i = 0; i < 10; i++) {
				log.info("test1 - {} {}", j, i);
			}
		}
	}

	/**
	 * 修饰一个静态方法,同一时间只有一个线程执行
	 * 
	 * @param j
	 */
	public static synchronized void test2(int j) {
		for (int i = 0; i < 10; i++) {
			log.info("test2 - {} {}", j, i);
		}
	}

	public static void main(String[] args) throws Exception {
		SynchronizedExample2 se1 = new SynchronizedExample2();
		SynchronizedExample2 se2 = new SynchronizedExample2();
		ExecutorService ex = Executors.newCachedThreadPool();
		ex.execute(() -> {
			se1.test1(1);
		});
		ex.execute(() -> {
			se2.test1(2);
		});
		ex.shutdown();
	}
}
