package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.services.CibilScoreService;

@RestController
@CrossOrigin(origins="*")
public class CibilScoreController {

	@Autowired
	private CibilScoreService service;
	
	@PostMapping(path="/api/v1/cibilScores")
	@ResponseStatus(code=HttpStatus.CREATED)
	public CibilScore addScore(@RequestBody CibilScore entity)
	{
		return this.service.add(entity);
	}
	
	@GetMapping(path="/api/v1/cibilScores")
	public List<CibilScore> findAll()
	{
		return this.service.findAll();
	}
	
	@GetMapping(path="api/v1/cibilScores/{panNumber}")
	public CibilScore findById(@PathVariable("panNumber") String key)
	{
		return this.service.findById(key);
	}
	
}
