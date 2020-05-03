package com.keluoluo.www.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedExample1 {
	/**
	 * 修饰一个代码块
	 */
	public void test1(int j) {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				log.info("test1 - {} {}", j, i);
			}
		}
	}

	/**
	 * 修饰一个方法
	 * 
	 * @param j
	 */
	public synchronized void test2(int j) {
		for (int i = 0; i < 10; i++) {
			log.info("test2 - {} {}", j, i);
		}
	}

	public static void main(String[] args) throws Exception {
		SynchronizedExample1 se1 = new SynchronizedExample1();
		SynchronizedExample1 se2 = new SynchronizedExample1();
		ExecutorService ex = Executors.newCachedThreadPool();
		ex.execute(() -> {
			se1.test2(1);
		});
		ex.execute(() -> {
			se2.test2(2);
		});
		ex.shutdown();
	}
}
