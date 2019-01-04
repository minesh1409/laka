package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IForeignExchangeDao;
import com.lakazambia.api.model.ForeignExchange;

@Service
public class ForeignExcgangeService implements IForeignExchangeService{
	
	@Autowired
	private IForeignExchangeDao foreignexchangedao;

	@Override
	public List<ForeignExchange> getExchange() {
		// TODO Auto-generated method stub
		return foreignexchangedao.getExchage();
	}
	
	
	

}
