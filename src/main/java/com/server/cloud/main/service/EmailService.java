package com.server.cloud.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	 public void sendVerificationEmail(String toEmail, String verificationCode) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(toEmail);
	        message.setSubject("이메일 인증 하기");
	        message.setText("인증번호는 : " + verificationCode+"입니다. 입력해주세요");
	        emailSender.send(message);
	        
	    }
//	 public void mailSend(MailVO mailVO) {
//	        SimpleMailMessage message = new SimpleMailMessage();
//	        message.setTo(mailVO.getAddress());
//	        message.setFrom(MailService.FROM_ADDRESS);
//	        message.setSubject(mailVO.getTitle());
//	        message.setText(mailVO.getMessage());
//
//	        mailSender.send(message);
//	    }
	 
	
}
