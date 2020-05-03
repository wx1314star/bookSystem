package com.keluoluo.www.example.commonUnsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.keluoluo.www.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class HashSetExample {
	// 请求总数
	public static int clientTool = 5000;
	// 同时并发执行的线程数
	public static int threadTool = 200;

	private static Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore sema = new Semaphore(threadTool);
		final CountDownLatch couLatch = new CountDownLatch(clientTool);
		for (int i = 0; i < clientTool; i++) {
			final int count = i;
			exec.execute(() -> {
				try {
					sema.acquire();
					update(count);
					sema.release();
				} catch (Exception e) {
					// e.printStackTrace();
					log.error("error{}", e);
				}
				couLatch.countDown();
			});
		}
		couLatch.await();
		exec.shutdown();
		log.info("size: {}", set.size());
	}

	public static void update(int i) {
		set.add(i);
	}
}
