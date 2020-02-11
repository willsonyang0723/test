package com.yy.test.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yongyang
 * 读写锁
 */
public class WirteReadLock_HasLock_sync {
	
	static Integer v = 0;
	public static void main(String[] args) {
		
		ExecutorService es =Executors.newFixedThreadPool(10);
		//会读会写的
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					synchronized (v) {
						v++;
						System.out.println(Thread.currentThread().getId() + ":" + (v-1) + ">" +v);
					}
				}
			}
		});
		//只读不写的
		for (int i = 0; i < 9; i++) {
			
			es.submit(new Runnable() {
				
				@Override
				public void run() {
					while(true)
					System.out.println(Thread.currentThread().getId() + ":" + v );
				}
			});
		}
		
	}

}
