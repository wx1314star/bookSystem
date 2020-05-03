package com.keluoluo.www.example.commonUnsafe;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.keluoluo.www.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class DateFormatExample2 {

	// 请求总数
	public static int clientTool = 5000;
	// 同时并发执行的线程数
	public static int threadTool = 200;

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore sema = new Semaphore(threadTool);
		final CountDownLatch couLatch = new CountDownLatch(clientTool);
		for (int i = 0; i < clientTool; i++) {
			exec.execute(() -> {
				try {
					sema.acquire();
					update();
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
	}

	public static void update() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			System.out.println(sdf.parse("2018-02-08"));
		} catch (Exception e) {
			log.info("error: {}", e);
		}
	}
}
