package com.scheduler.dokcer_fo_mail.task;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;

@Component
public  class EmailSender {
	
	@Value("${email.send.waqf.from}")
	private String fromEmail;
	
	@Value("${email.send.waqf.to}")
	private String toEmail;
	
	@Async("mailAsync")
	public  void sendEmailForOrderConfirmations(String emailId, String name, Double totalAmount) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message= "Hi! Mr. "+name+". Your order worth of "+String.valueOf(totalAmount)+ " is now confirmed. We are glad to serve you."; 
		try {
			sendEmail(emailId, message, name);
		} catch (MailjetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MailjetSocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Async("mailAsync")
	public  void sendEmail(String emailId, String message, String name) throws MailjetException, MailjetSocketTimeoutException {
		MailjetClient client;
		MailjetRequest request;
		MailjetResponse response;
		System.out.println("From emailId is-->"+fromEmail);
		System.out.println("To emailId is-->"+toEmail);

		client = new MailjetClient("3e292e1e3e850abe850793dbb22554b9",
				"2fa15000afb8c7ad2cd676c9828bcd5e", new ClientOptions("v3.1"));
		request = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES,
				new JSONArray().put(new JSONObject()
						.put(Emailv31.Message.FROM, new JSONObject().put("Email", fromEmail)
								.put("Name", "Reject Waqf Amendment Bill"))
						.put(Emailv31.Message.TO,
								new JSONArray().put(
										new JSONObject().put("Email", toEmail).put("JPC Waqf Board", "Hello")))
						.put(Emailv31.Message.SUBJECT, "Complete Rejection of the Waqf Amendment Bill, 2024.")
						.put(Emailv31.Message.TEXTPART, "Dear Members of the Joint Parliamentary Committee,\n"
								+ "I strongly oppose the Waqf Amendment Bill. It violates fundamental rights, Islamic charity laws, and established judicial principles while introducing significant operational inefficiencies.\n"
								+ "If adopted, this bill will transfer a majority of the control of Waqf properties to the government, reduce these properties through reclassification, and establish an opaque, biased, and inefficient structure for managing Waqf assets.\n"
								+ "Such legislation erodes public trust in the Constitution. I urge you to revoke this bill immediately.\n"
								+ "Sincerely, ")
						.put(Emailv31.Message.HTMLPART,
								"<h3>"+"Dear Members of the Joint Parliamentary Committee,\n"
										+ "I strongly oppose the Waqf Amendment Bill. It violates fundamental rights, Islamic charity laws, and established judicial principles while introducing significant operational inefficiencies.\n"
										+ "If adopted, this bill will transfer a majority of the control of Waqf properties to the government, reduce these properties through reclassification, and establish an opaque, biased, and inefficient structure for managing Waqf assets.\n"
										+ "Such legislation erodes public trust in the Constitution. I urge you to revoke this bill immediately.\n")
						.put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
		response = client.post(request);
		System.out.println(response.getStatus());
		System.out.println(response.getData());
	}

}