package com.keluoluo.www.example.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.keluoluo.www.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class AtomicExample6 {
	private static AtomicBoolean isHappend = new AtomicBoolean(false);

	public static int clientTool = 5000;
	// 同时并发执行的线程数
	public static int threadTool = 200;
	public static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore sema = new Semaphore(threadTool);
		final CountDownLatch couLatch = new CountDownLatch(clientTool);
		for (int i = 0; i < clientTool; i++) {
			exec.execute(() -> {
				try {
					sema.acquire();
					test();
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
		log.info("isHappend {}", isHappend.get());
	}

	public static void test() {
		if (isHappend.compareAndSet(false, true))
			log.info("execute!");
	}
}
