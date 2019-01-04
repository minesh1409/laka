package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Favourites;

public interface IFavouriteService {
	
	boolean createFavourites(Favourites fav);

	Favourites getFavouritesById(int id);

	List<Favourites> getAllFavourites();

	void updateFavourites(Favourites fav);
	
	void deleteFavourites(int fid);

}
