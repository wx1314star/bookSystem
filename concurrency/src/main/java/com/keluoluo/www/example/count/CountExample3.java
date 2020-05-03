package com.keluoluo.www.example.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.keluoluo.www.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class CountExample3 {

	// 请求总数
	public static int clientTool = 5000;
	// 同时并发执行的线程数
	public static int threadTool = 200;
	public static int count = 0;

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

	public synchronized static void add() {
		count++;
	}
}
