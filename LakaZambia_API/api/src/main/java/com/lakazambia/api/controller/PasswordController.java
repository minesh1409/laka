package com.lakazambia.api.controller;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lakazambia.api.model.Customer;
import com.lakazambia.api.service.EmailService;
import com.lakazambia.api.service.frgtPasswordService;

@RestController
public class PasswordController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordController.class);
	
	
	@Autowired
	private frgtPasswordService frgtpswdservice;
	
	@Autowired
	private EmailService emailService;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/forgot/{email}", method = RequestMethod.POST)
	public ResponseEntity<String> processForgotPasswordForm(@PathVariable("email") String userEmail, HttpServletRequest request,ModelAndView modelAndView) {

		// Lookup user in database by e-mail
		Optional<Customer> optional = frgtpswdservice.findUserByEmail(userEmail);

		if (!optional.isPresent()) {
			LOGGER.info("Email Not Found");
			return new ResponseEntity<String>("Email Not Found",HttpStatus.OK);
			
		} else {
			
			// Generate random 36-character string token for reset password 
			Customer customer = optional.get();
			customer.setResetToken(UUID.randomUUID().toString());

			// Save token to database
			frgtpswdservice.save(customer);;

			String appUrl = request.getScheme() + "://" + request.getServerName();//+ ":" +request.getServerPort();
			System.out.println("appUrl 1 :: " +request.getScheme());
			System.out.println("appUrl 2 :: " +request.getServerName());
			System.out.println("PORT :: " +request.getServerPort());
			// Email message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("no-reply@lakazambia.com");
			passwordResetEmail.setTo(customer.getEmail());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
					+ "/reset?token=" + customer.getResetToken());
			
			emailService.sendEmail(passwordResetEmail);

			// Add success message to view
			//modelAndView.addObject("successMessage", "A password reset link has been sent to " + userEmail);
			LOGGER.info("Email Send in this mail id "+userEmail);
			return new ResponseEntity<String>("A password reset link has been sent to "+userEmail,HttpStatus.OK);
		}
		
		
	}

	// Display form to reset password
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
		
		Optional<Customer> user = frgtpswdservice.findUserByResetToken(token);

		if (user.isPresent()) { // Token found in DB
			modelAndView.addObject("resetToken", token);
		} else { // Token not found in DB
			LOGGER.info("This is an invalid password reset link.");
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
		}

		modelAndView.setViewName("reset");
		return modelAndView;
	}

	// Process reset password form
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

		// Find the user associated with the reset token
		Optional<Customer> user = frgtpswdservice.findUserByResetToken(requestParams.get("token"));

		// This should always be non-null but we check just in case
		if (user.isPresent()) {
			
			Customer resetUser = user.get(); 
            String pswd=requestParams.get("password");
            String confPswd=requestParams.get("confim_password");
			// Set new password    
            if(pswd.equals(confPswd))
            {
            	resetUser.setPassword(bCryptPasswordEncoder.encode(pswd));
            }
			// Set the reset token to null so it cannot be used again
			resetUser.setResetToken(null);

			// Save user
			frgtpswdservice.save(resetUser);

			// In order to set a model attribute on a redirect, we must use
			// RedirectAttributes
			LOGGER.info("successfully reset your password");
			redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");


			
		} 
		
		return modelAndView;
   }
   
    /*// Going to reset page without a token redirects to login page
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:login");
	}*/
}
