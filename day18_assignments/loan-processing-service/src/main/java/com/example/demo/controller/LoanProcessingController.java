package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CibilScore;

@RestController
@CrossOrigin(origins="*")
public class LoanProcessingController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping(path="/api/v1/scores/{id}")
	public String getCibilScore(@PathVariable("id") String panNumber)
	{
		String url="http://CIBIL-SCORE-SERVICE/api/v1/cibilScores/"+panNumber;
		
		//String cibilScore=this.template.getForObject(url,String.class);
		CibilScore cibilScore=this.template.getForObject(url,CibilScore.class);

		String eligible=null;
		
		if(cibilScore.getScore()<200)
		{
			eligible="only car loan";
		}
		else if(cibilScore.getScore()>200)
		{
			eligible="home and car loan";
		}
		
		return eligible;
	}
	
}
