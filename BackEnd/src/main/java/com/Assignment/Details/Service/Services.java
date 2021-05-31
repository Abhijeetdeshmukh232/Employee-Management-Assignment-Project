package com.Assignment.Details.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.Assignment.Details.Entity.Employee;
import com.Assignment.Details.Repository.EmployeeRepository;
/**
 * 
 * This  class  provides  business functionalities for use cases.
 *
 */

@Service
public class Services {
	@Autowired
	private EmployeeRepository employeerepository;
	
	  
	/**
	 * This method provide way to save details of a give employee object into persistent database.
	 * @param employee given employee object which will be saved in database
	 * @return saved employee object.
	 */
	public Employee save(Employee employee)
	{
		return employeerepository.save(employee);
	}
	
	/**
	 * This method provide functionality to perform a search for input search value and search option
	 * @param searchByValue holds the input field on which search will be performed.
	 * @param searchOnValue holds the input operation which will be used to search the entry. 
	 * @param searchValue hold the input that need to be searched.
	 * @return search result as list of employee.
	 */
	
	public List<Employee> search(String searchByValue,String searchOnValue, String searchValue){
		
		String searchExpression ="";
		
		switch(searchOnValue)
		{
		case "likeMatch":
			if(searchByValue.equals("firstName")) {
				return employeerepository.findAllByFirstName(searchValue);
			} else if (searchByValue.equals("lastName")) {
				System.out.println("Like Search");
				return employeerepository.findAllByLastName(searchValue);
			} else if (searchByValue.equals("city")) {
				return employeerepository.findAllByCity(searchValue);
			}else if (searchByValue.equals("employeeID")) {
				return employeerepository.findAllById(searchValue);
				}
		case "exactMatch":
			if(searchByValue.equals("firstName")) {
				return employeerepository.findAllByFirstNameExactMatch(searchValue);
			} else if (searchByValue.equals("lastName")) {
				System.out.println("Like Search");
				return employeerepository.findAllByLastNameExactMatch(searchValue);
			} else if (searchByValue.equals("city")) {
				return employeerepository.findAllByCityExactMatch(searchValue);
			}else if (searchByValue.equals("employeeID")) {
				return employeerepository.findAllByIdExactMatch(searchValue);
			}
		case "notLikeMatch":
			if(searchByValue.equals("firstName")) {
				return employeerepository.findAllByFirstNameNotLikeMatch(searchValue);
			} else if (searchByValue.equals("lastName")) {
				System.out.println("Like Search");
				return employeerepository.findAllByLastNameNotLikeMatch(searchValue);
			} else if (searchByValue.equals("city")) {
				return employeerepository.findAllByCityNotLikeMatch(searchValue);
			}else if (searchByValue.equals("employeeID")) {
				return employeerepository.findAllByIdNotLikeMatch(searchValue);
			}
			
		
		}
	
        System.out.println(searchExpression);
        return new ArrayList<>();
       
	}
	
	


}