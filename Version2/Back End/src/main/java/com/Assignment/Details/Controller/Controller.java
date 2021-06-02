package com.Assignment.Details.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.Details.Entity.Employee;
import com.Assignment.Details.Service.Services;

@RestController
@RequestMapping("/employee")
public class Controller {
	@Autowired
	private Services services;
	
	
	/**
	 * This method exposes the save operation and allow give employee object to be saved.
	 * @param employee given employee object to be saved
	 * @return the saved employee
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/post")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return services.save(employee);
	}
	/**
	 * This method exposes the search functionality maps the url and path variable.
	 * @param searchByValue holds the input field on which search will be performed.
	 * @param searchOnValue holds the input operation which will be used to search the entry. 
	 * @param searchValue hold the input that need to be searched.
	 * @return search result as list of employee.
	 */
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{searchByValue}/{searchOnValue}/{searchValue}")
	public List<Employee> findAllEmployee(@PathVariable("searchByValue") String searchByValue,
			@PathVariable("searchOnValue") String searchOnValue ,
			@PathVariable("searchValue") String searchValue )
	
	{
		System.out.println(searchByValue+"///"+searchOnValue+"///"+searchValue);
		return services.search(searchByValue,searchOnValue,searchValue);
	}
	

}
