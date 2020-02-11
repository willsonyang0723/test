package com.yy.test.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yongyang
 * 读写锁
 */
public class WirteReadLock_HasLock_wr {
	
	static Integer v = 0;
	public static void main(String[] args) {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		ExecutorService es =Executors.newFixedThreadPool(10);
		//会读会写的
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						lock.writeLock().lock();
						v++;
						System.out.println(Thread.currentThread().getId() + ":" + (v-1) + ">" +v);
					} finally {
						lock.writeLock().unlock();
					}
					
						
					
				}
			}
		});
		//只读不写的
		for (int i = 0; i < 9; i++) {
			
			es.submit(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						try {
							lock.readLock().lock();
							System.out.println(Thread.currentThread().getId() + ":" + v );
						} finally {
							lock.readLock().unlock();
						}
					}
					
				}
			});
		}
		
	}

}
