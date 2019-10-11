package com.mortgage.ing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mortgage.ing.service.SchedulerServiceImpl;



@Component
public class TransactionSecheduler {

	@Autowired
	private SchedulerServiceImpl schedulerServiceImpl;
	
	@Scheduled(cron = "0 */1 * * * *")
	public void runTask() {
		schedulerServiceImpl.runTask();
	}
}
