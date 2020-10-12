package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CibilScore;
import com.example.demo.repos.CibilScoreRepository;

@Service
public class CibilScoreService {

	@Autowired
	private CibilScoreRepository repo;
	
	public CibilScore add(CibilScore entity)
	{
		return repo.save(entity);
	}
	
	public List<CibilScore> findAll()
	{
		return repo.findAll();
	}
	
	public CibilScore findById(String key)
	{
		Optional<CibilScore> resp= repo.findById(key);
		
		CibilScore obj=null;
		
		if(resp.isPresent())
		{
			obj=resp.get();
		}
		else
		{
			throw new RuntimeException("element not found");
		}
		
		return obj;
	}
}
