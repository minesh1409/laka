package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IEmailDao;
import com.lakazambia.api.model.Email;

@Service
public class EmailService implements IEmailService{
	
	
	@Autowired
	private IEmailDao emailDao;
	
	@Autowired
	private JavaMailSender mailSender;

	



	@Override
	public boolean createEmail(Email u) {
		// TODO Auto-generated method stub
		emailDao.createEmail(u);
		return true;
	}

	@Override
	public List<Email> getAllEmails() {
		// TODO Auto-generated method stub
		return emailDao.getAllEmails();
	}

	@Override
	public void sendMail(String toEmail, String subject, String message) {
		// TODO Auto-generated method stub
		emailDao.sendMail(toEmail, subject, message);
	}

	@Async
	public void sendEmail(SimpleMailMessage email) {
		// TODO Auto-generated method stub
		mailSender.send(email);
	}

	

}
