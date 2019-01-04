package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IFavoriteDao;
import com.lakazambia.api.model.Favourites;

@Service
public class FavouritesService implements IFavouriteService{
	
	
	@Autowired
	private IFavoriteDao favouriteDao;

	@Override
	public boolean createFavourites(Favourites fav) {
		// TODO Auto-generated method stub
		favouriteDao.createFavourite(fav);
		return true;
	}

	@Override
	public Favourites getFavouritesById(int id) {
		// TODO Auto-generated method stub
		return favouriteDao.getFavouriteById(id);
	}

	@Override
	public List<Favourites> getAllFavourites() {
		// TODO Auto-generated method stub
		return favouriteDao.getAllFavourites();
	}

	@Override
	public void updateFavourites(Favourites fav) {
		// TODO Auto-generated method stub
		favouriteDao.updateFavourite(fav);
	}

	@Override
	public void deleteFavourites(int fid) {
		// TODO Auto-generated method stub
		favouriteDao.deleteUser(fid);
	}

}
