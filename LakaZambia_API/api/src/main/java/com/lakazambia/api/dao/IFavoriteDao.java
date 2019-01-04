package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Favourites;


public interface IFavoriteDao {
	
	void createFavourite(Favourites u);

	List<Favourites> getAllFavourites();

	void updateFavourite(Favourites u);

	Favourites getFavouriteById(int FavouriteId);
	
	public void deleteUser(int fId); 

	

}
