package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Email;

@Transactional
@Repository
public class EmailDao implements IEmailDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void createEmail(Email e) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		e.setCreated_at(sdf.format(date));
		String email = e.getEmail();
		String subject = e.getSubject();
		String message = e.getMessage();
		if (sendMail(email, subject, message)) {
			System.out.println("MAil send........");
			entitymanager.persist(e);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Email> getAllEmails() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Email").getResultList();
	}

	public boolean sendMail(String toEmail, String subject, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("no-reply@lakazambia.com");
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailMessage.setFrom(toEmail);
		javaMailSender.send(mailMessage);
		return true;

	}

}
