package com.scheduler.dokcer_fo_mail.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

@Component
public class ScheduledTasks {
	
	@Autowired
	EmailSender email;

	@Scheduled(fixedRate = 300000)
	public void sendEmail() {
		System.out.println("checking the scheduler");
		try {
			email.sendEmail("junaidraza3002@gmail.com", "checking", "junaid");
		} catch (MailjetException | MailjetSocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
