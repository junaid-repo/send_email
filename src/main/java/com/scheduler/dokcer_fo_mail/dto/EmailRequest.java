package com.scheduler.dokcer_fo_mail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {

	String toEmailId = "";
	String fromEmailId = "";
	String receiptName = "";
	String senderName = "";
	String subject = "";
	String content="";

}
