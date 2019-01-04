package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Customer;



@Transactional
@Repository
public class CustomerDao implements ICustomerDao{
	
	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Customer findByCustomername(String Customername) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(Long CustomerId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Customer.class,CustomerId);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return entitymanager.find(Customer.class,email);
	}

	@Override
	public Customer getCustomerByMobile(String mobile) {
		// TODO Auto-generated method stub
		return entitymanager.find(Customer.class, mobile);
	}

	@Override
	public void createCustomer(Customer u) throws ParseException {
		// TODO Auto-generated method stub
		Long id=u.getUser_id();
		System.out.println("Id is :: " +id);
		 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		//String pswd=u.getPassword();
		/*String confirmPswd=u.getPswdConfirm();
		if(pswd.equals(confirmPswd))
		{*/
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		//}
			u.setCreated_at(sdf.format(date));
		
			System.out.println("Encrypted Password"+bCryptPasswordEncoder.encode(u.getPassword()));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Customer").getResultList();
	}


	@Override
	public void updateCustomer(Customer u) {
		// TODO Auto-generated method stub
		System.out.println("User ID IS ::: "+u.getUser_id());
		Customer c =getCustomerById(u.getUser_id());
		c.setUsername(u.getUsername());
		//user.setPassword(u.getPassword());
		//entityManager.persist(u);
		c.setAddress(u.getAddress());
		c.setMobile(u.getMobile());
		c.setEmail(u.getEmail());
		c.setFname(u.getFname());
		c.setLname(u.getLname());
		c.setOccupation(u.getOccupation());
		c.setAbout(u.getAbout());
		c.setWebsiteUrl(u.getWebsiteUrl());
		c.setAvatar(u.getAvatar());
		entitymanager.flush();
	}

	/*@Override
	public boolean doLogin(String name, String pswd) {
		// TODO Auto-generated method stub
		User results = null;
		
		try {
			
		System.out.println("Login Password :: "+pswd);
		TypedQuery<User> qry = entitymanager.createQuery("FROM Customer as u where u.email = '" + name + "'",
					User.class);
			results = qry.getSingleResult();
		  		String st=results.getPassword();
		    //  String st = result[1].toString();
			if(bCryptPasswordEncoder.matches(pswd, st))
			{
				System.out.println(bCryptPasswordEncoder.matches(pswd, st));
				System.out.println("Password Matches......!!!");
				System.out.println("User Find...");
				//u=getUserByEmail(name);
				return true;
				
			}
			else
			{
				System.out.println("User Not Exists...");
				return false;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}*/

	@Override
	public void deleteCustomer(Long CustomerId) {
		// TODO Auto-generated method stub
		Customer c=getCustomerById(CustomerId);
		entitymanager.remove(c);
	}
	
	public Customer doLogin(String name, String pswd) {
		// TODO Auto-generated method stub
		Customer results = null;

		try {

			System.out.println("Login Password :: " + pswd);
			TypedQuery<Customer> qry = entitymanager.createQuery("select u from Customer as u where u.email = '" + name + "'",
					Customer.class);
			results = qry.getSingleResult();
			String st = results.getPassword();
			// String st = result[1].toString();
			if (bCryptPasswordEncoder.matches(pswd, st)) {
				System.out.println(bCryptPasswordEncoder.matches(pswd, st));
				System.out.println("Password Matches......!!!");
				System.out.println("User Find...");
				// u=getUserByEmail(name);
				return results;
			} else {
				
				System.out.println("User Not Exists...");
				return null;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;

	}

	@Override
	public void updateCustomerStatus(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Id id :: " +customer.getUser_id());
		Customer c=getCustomerById(customer.getUser_id());
		c.setStatus(customer.getStatus());
		System.out.println("Updated Status is :: " +customer.getStatus());
		entitymanager.flush();
	}


	

	
	
}
