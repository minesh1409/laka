package com.lakazambia.api.service;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;

import com.lakazambia.api.model.Email;

public interface IEmailService {

	boolean createEmail(Email u);

	List<Email> getAllEmails();
	
	public void sendMail(String toEmail, String subject, String message);
	
	public void sendEmail(SimpleMailMessage email);
	
	
}
