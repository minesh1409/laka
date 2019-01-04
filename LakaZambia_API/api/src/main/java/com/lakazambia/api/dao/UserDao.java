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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.connection.RethinkDBConnectionFactory;
import com.lakazambia.api.model.User;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Cursor;

@Transactional
@Repository
@PropertySource("classpath:db.properties")
public class UserDao implements IUserDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;

	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema}")
	public String tab;

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return entitymanager.find(User.class, userId);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return entitymanager.find(User.class, email);
	}

	@Override
	public User getUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		return entitymanager.find(User.class, mobile);
	}

	@Override
	public void createUser(User u) throws ParseException {
		// TODO Auto-generated method stub
		/*
		 * Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
		 */
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		u.setCreated_at(sdf.format(date));

		System.out.println("Encrypted Password" + bCryptPasswordEncoder.encode(u.getPassword()));

		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		String hql = "FROM User";
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public boolean UserExists(String email) {
		// TODO Auto-generated method stub
		String hql = "FROM User as u WHERE u.email = ? ";
		int count = entitymanager.createQuery(hql).setParameter(1, email).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("In Dao");
		System.out.println("User ID IS ::: " + u.getUser_id());
		User user = getUserById(u.getUser_id());
		if (u.getUsername() != null) {
			user.setUsername(u.getUsername());
			System.out.println(u.getUsername());}
		if(u.getAddress()!=null) {
			user.setAddress(u.getAddress());
			System.out.println(u.getAddress());}
		if(u.getMobile()==0) {
			user.setMobile(u.getMobile());
			System.out.println(u.getMobile());}
		if(u.getEmail()!=null) {
			user.setEmail(u.getEmail());
			System.out.println(u.getEmail());}
		if(u.getFname()!=null) {
			user.setFname(u.getFname());
			System.out.println(u.getFname());}
		if(u.getLname()!=null){
			user.setLname(u.getLname());
			System.out.println(u.getLname());}
		if(u.getOccupation()!=null) {
			user.setOccupation(u.getOccupation());
			System.out.println(u.getOccupation());}
		if(u.getAbout()!=null) {
			user.setAbout(u.getAbout());
			System.out.println(u.getAbout());}
		if(u.getWebsiteUrl()!=null) {
			user.setWebsiteUrl(u.getWebsiteUrl());
			System.out.println(u.getWebsiteUrl());}
		if(u.getAvatar()!=null) {
			user.setAvatar(u.getAvatar());
			System.out.println(u.getAvatar());}
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(sdf.format(date));
			// u.setCreated_at(sdf.format(date));
			user.setUpdated_at(sdf.format(date));
		
		entitymanager.flush();

	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return entitymanager.find(User.class, username);
	}

	public User doLogin(String name, String pswd) {
		// TODO Auto-generated method stub
		User results = null;

		try {

			System.out.println("Login Password :: " + pswd);
			TypedQuery<User> qry = entitymanager.createQuery("select u from User as u where u.email = '" + name + "'",
					User.class);
			results = qry.getSingleResult();
			String st = results.getPassword();
			// String st = result[1].toString();
			if (bCryptPasswordEncoder.matches(pswd, st)) {
				System.out.println(bCryptPasswordEncoder.matches(pswd, st));
				System.out.println("Password Matches......!!!");
				System.out.println("User Find...");
				// u=getUserByEmail(name);

			} else {
				System.out.println("User Not Exists...");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;

	}

	// FOR RETHINK

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		/*
		 * String hql = "FROM User"; return ((List<User>)
		 * entitymanager.createQuery(hql).getResultList());
		 */
		List<User> users = r.db(db).table(tab)
				// .orderBy().optArg("index", r.desc("time"))
				.limit(50).orderBy("time").run(connectionFactory.createConnection());
		return users;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<User> getUserByID(int uid) {

		System.out.println("ID id:: " + uid);
		System.out.println("r.db(" + db + ").table(" + tab + ").get(" + uid + ").");

		Cursor cursor = r.db(db).table(tab).filter(user -> user.g("uid").eq(uid))
				.run(connectionFactory.createConnection());

		@SuppressWarnings("unchecked")
		List<User> users = cursor.toList();
		System.out.println("Users data ::" + users);
		System.out.println("IN DAO");
		return users;
		// return r.db(db).table(tab).filter(user ->
		// user.g("uid").eq(uid)).run(connectionFactory.createConnection());
	}

}
