package com.lakazambia.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.UpdateVersion;

@Repository
@Transactional
public class UpdateVersionDao implements IUpdateVersion{
	
	
	@Autowired
	private EntityManager em;

	@Override
	public void createVersion(UpdateVersion v) {
		// TODO Auto-generated method stub
		em.persist(v);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.lakazambia.api.model.UpdateVersion> getVersions() {
		// TODO Auto-generated method stub
		return em.createQuery("FROM UpdateVersion").getResultList();
	}

	@Override
	public com.lakazambia.api.model.UpdateVersion getVersionById(int id) {
		// TODO Auto-generated method stub
		return em.find(UpdateVersion.class, id);
	}

}
