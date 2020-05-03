package com.keluoluo.www.example.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

import com.keluoluo.www.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class AtomicExample2 {

	// 请求总数
	public static int clientTool = 5000;
	// 同时并发执行的线程数
	public static int threadTool = 200;
	// 性能比AtomicLong高,线程低时用AtomicLong
	public static LongAdder count = new LongAdder();

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore sema = new Semaphore(threadTool);
		final CountDownLatch couLatch = new CountDownLatch(clientTool);
		for (int i = 0; i < clientTool; i++) {
			exec.execute(() -> {
				try {
					sema.acquire();
					add();
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
		log.info("count{}", count);
	}

	public static void add() {
		count.increment();// i++
		// count.getAndIncrement();//++i
	}
}
