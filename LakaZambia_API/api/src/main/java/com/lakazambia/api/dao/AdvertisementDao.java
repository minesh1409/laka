package com.lakazambia.api.dao;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;


import com.lakazambia.api.connection.RethinkDBConnectionFactory;
import com.lakazambia.api.model.Advertisement;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Cursor;

@Transactional
@Repository
@PropertySource("classpath:db.properties")
public class AdvertisementDao implements IAdvertisementDao {

	@Autowired
	private EntityManager entitymanager;
	
	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;
	
	
	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema2}")
	public String tab;

	@Override
	public void createAdvertisement(Advertisement u) {
		// TODO Auto-generated method stub
		Advertisement result;
		String hql="select u FROM Advertisement as u ORDER BY u.listing_id DESC";
		System.out.println(hql);
		TypedQuery<Advertisement> qry = entitymanager.createQuery(hql,Advertisement.class);
		result= qry.setMaxResults(1).getSingleResult();
		System.out.println("Listing id :: " +result.getListing_id());
		int id=result.getListing_id();
		int list_id = id + 1;
		System.out.println("Set Advertisement Id :: " +list_id);
		u.setListing_id(list_id);
		System.out.println("Listing Id :: " +u.getListing_id());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));

		u.setSlug(u.getTitle());
		
		u.setCreated_at(sdf.format(date));
		entitymanager.merge(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAllAdvertisements() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Advertisement").getResultList();
	}

	@Override
	public void updateAdvertisement(Advertisement u) {
		// TODO Auto-generated method stub
		Advertisement adv = getAdvertisementById(u.getListing_id());
		adv.setPackage_id(u.getPackage_id());
		adv.setCurrency_id(u.getCurrency_id());
		adv.setTitle(u.getTitle());
		adv.setSlug(u.getSlug());
		adv.setDescription(u.getDescription());
		adv.setPrice(u.getPrice());
		adv.setNegotiable(u.getNegotiable());
		adv.setHide_phone(u.getHide_phone());
		adv.setHide_email(u.getHide_email());
		adv.setImgpath(u.getImgpath());
		adv.setRemaining_auto_renewal(u.getRemaining_auto_renewal());
		adv.setPromo_expire_at(u.getPromo_expire_at());
		adv.setListing_expire_at(u.getListing_expire_at());
		adv.setStatus(u.getStatus());
		adv.setGood_usage(u.getGood_usage());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		adv.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public Advertisement getAdvertisementById(int advertisementId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Advertisement.class, advertisementId);
	}

	@Override
	public List<Advertisement> findAll() {
		// TODO Auto-generated method stub
		 List<Advertisement> ads =r.db(db).table(tab)
	    		   //.orderBy().optArg("index", r.desc("time"))
	                .limit(50)
	               .orderBy("time")
	    		   .run(connectionFactory.createConnection());
		 return ads;
	}

	@Override
	public List<Advertisement> getAdvertisementByID(int ad_id) {
		// TODO Auto-generated method stub
		
		System.out.println("ID id:: "+ad_id);
		System.out.println("r.db("+db+").table("+tab+").get("+ ad_id +").");
	
		@SuppressWarnings("rawtypes")
		Cursor cursor =r.db(db).table(tab).filter(user -> user.g("uid").eq(ad_id)).run(connectionFactory.createConnection());
		
		@SuppressWarnings("unchecked")
		List<Advertisement> ads=cursor.toList();
		System.out.println("Users data ::" +ads);
		System.out.println("IN DAO");
		return  ads;
	}

	@Override
	public void deleteAdvertisement(int id) {
		// TODO Auto-generated method stub
		Advertisement ad=getAdvertisementById(id);
		entitymanager.remove(ad);
	}
	
}
