package com.yy.test.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yongyang
 * 读写锁
 */
public class WirteReadLock_NoLock {
	
	static int v = 0;
	public static void main(String[] args) {
		
		ExecutorService es =Executors.newFixedThreadPool(10);
		//会读会写的
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.print(Thread.currentThread().getId() + ":" + v + ">");
					v++;
					System.out.println(v);
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
