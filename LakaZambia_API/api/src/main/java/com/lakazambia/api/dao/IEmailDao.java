package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Email;

public interface IEmailDao {

	void createEmail(Email e);

	List<Email> getAllEmails();
	
	public boolean sendMail(String toEmail, String subject, String message);

}
