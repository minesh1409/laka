package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Favourites;

@Transactional
@Repository
public class FavouriteDao implements IFavoriteDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createFavourite(Favourites u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Favourites> getAllFavourites() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Favourites").getResultList();
	}

	@Override
	public void updateFavourite(Favourites u) {
		// TODO Auto-generated method stub
		Favourites fav = getFavouriteById(u.getFavourite_id());
		fav.setCreated_at(u.getCreated_at());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public Favourites getFavouriteById(int FavouriteId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Favourites.class, FavouriteId);
	}

	@Override
	public void deleteUser(int fId) {
		// TODO Auto-generated method stub
		Favourites f=getFavouriteById(fId);
		entitymanager.remove(f);
	}

}
