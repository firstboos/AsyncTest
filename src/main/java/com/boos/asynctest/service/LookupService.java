package com.boos.asynctest.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LookupService {
	@Async
	public void findPage(String name) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Name: " + name);
	}
}
