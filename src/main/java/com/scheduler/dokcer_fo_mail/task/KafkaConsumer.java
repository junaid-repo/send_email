package com.scheduler.dokcer_fo_mail.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scheduler.dokcer_fo_mail.dto.EmailRequest;

@Component
public class KafkaConsumer {
	
	@Autowired
	EmailSender emailSender;
	
	@KafkaListener(
			topics="${spring.kafka.topic.name}",
			groupId="${spring.kafka.consumer.group-id}"
			)
		public void consume(String requestString)
		{
			System.out.println("The email request is " + requestString.toString());
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				EmailRequest request = objectMapper.readValue(requestString, EmailRequest.class);
				System.out.println("The email object is " + request.toString());

				emailSender.sendEmail(request.getToEmailId(), request.getFromEmailId(), request.getReceiptName(),
						request.getSenderName(), request.getSubject(), request.getContent());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	

}
