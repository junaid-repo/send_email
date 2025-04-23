package com.scheduler.dokcer_fo_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.scheduler.dokcer_fo_mail.dto.EmailRequest;
import com.scheduler.dokcer_fo_mail.task.EmailSender;

@SpringBootApplication
@EnableScheduling
@RestController
public class DokcerFoMailApplication {
	
	@Autowired
	EmailSender emailSender;

	public static void main(String[] args) {
		SpringApplication.run(DokcerFoMailApplication.class, args);
	}
	
	/*
	 * @PostMapping("email/send") ResponseEntity<Integer> sendEmail(@RequestBody
	 * EmailRequest request){ MailjetResponse response=null; try {
	 * response=emailSender.sendEmail(request.getToEmailId(),
	 * request.getFromEmailId(), request.getReceiptName(), request.getSenderName(),
	 * request.getSubject(), request.getContent()); } catch (MailjetException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (MailjetSocketTimeoutException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return
	 * ResponseEntity.status(HttpStatus.OK).body(response.getStatus()); }
	 * 
	 * 
	 */
}
