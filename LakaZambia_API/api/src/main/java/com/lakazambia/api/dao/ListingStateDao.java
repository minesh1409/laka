package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.ListingState;

@Transactional
@Repository
public class ListingStateDao implements IListingStateDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createListingState(ListingState u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ListingState> getAllListingStates() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM ListingStat").getResultList();
	}

	@Override
	public void updateListingState(ListingState u) {
		// TODO Auto-generated method stub
		ListingState state = getListingStateById(u.getListing_id());
		state.setTotal_views(u.getTotal_views());
		state.setFacebook_shares(u.getFacebook_shares());
		state.setTwitter_shares(u.getTwitter_shares());
		state.setMail_shares(u.getMail_shares());
		state.setFavorite(u.getFavorite());
		state.setShow_phone(u.getShow_phone());
		state.setShow_mail(u.getShow_mail());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public ListingState getListingStateById(int ListingStateId) {
		// TODO Auto-generated method stub
		return entitymanager.find(ListingState.class, ListingStateId);
	}

}
