package com.expense.Sulaah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.Sulaah.service.SampleData;

@RestController
public class helloController {

	@Autowired
	private SampleData sampleDataService;

	@GetMapping("/")
	public String sayHello() {
		return "Hello World - come to Sulaah for one stop solution";
	}

	@PostMapping("/testData")
	public String addTestData() {
		return sampleDataService.addTestData();
	}
}
