package com.boos.asynctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.boos.asynctest.service.LookupService;

@Component
@EnableAsync
public class AsyncMain {
	@Autowired
	LookupService lookupService;
	
	public void run() throws InterruptedException {
		lookupService.findPage("aaa");
		System.out.println("Immediately print 1.");
		lookupService.findPage("bbb");
		System.out.println("Immediately print 2.");
		lookupService.findPage("ccc");
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		AsyncMain p = context.getBean(AsyncMain.class);
		try {
			p.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
