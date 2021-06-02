package com.Assignment.Details.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Assignment.Details.Entity.Employee;

/**
 * 
 * This is employee repository class  provides the mechanism
 * for storage, retrieval, search, update and delete operation on employee objects.
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
	
	   /**
	     * Like Match Query Start
	     */
	  @Query(
	            value = "SELECT * FROM employee WHERE first_name LIKE %:searchPattern%",	
	            nativeQuery = true
	            
	    )
	  
	  public List<Employee> findAllByFirstName(@Param("searchPattern") String searchPattern); 
	  
	  
	  @Query(
	            value = "SELECT * FROM employee WHERE last_name LIKE %:searchPattern%",	
	            nativeQuery = true
	            
	    )
	  
	  public List<Employee> findAllByLastName(@Param("searchPattern") String searchPattern);


	  @Query(
	            value = "SELECT * FROM employee WHERE city LIKE %:searchPattern%",		
			 nativeQuery = true
	            
	    )
	public List<Employee> findAllByCity(@Param("searchPattern") String searchPattern);
		
	  @Query(
	            value = "SELECT * FROM employee WHERE id LIKE %:searchPattern%",		
			 nativeQuery = true
	            
	    )
	  
	  
	  public List<Employee> findAllById(@Param("searchPattern") String searchPattern);
	  
	  
	  /**
	   * Exact Match Query Start
	   */
	  

	  @Query(
	            value = "SELECT * FROM employee WHERE first_name = ?1",			
	            nativeQuery = true
	            
	    )
	public List<Employee> findAllByFirstNameExactMatch(@Param("searchPattern") String searchValue);


	  @Query(
	            value = "SELECT * FROM employee WHERE last_name = ?1",				
	            nativeQuery = true
	            
	    )
	public List<Employee> findAllByLastNameExactMatch(@Param("searchPattern") String searchValue);


	 @Query(
	            value = "SELECT * FROM employee WHERE city = ?1",		
	            nativeQuery = true
	            
	    )
	public List<Employee> findAllByCityExactMatch(@Param("searchPattern") String searchValue);

	 @Query(
	            value = "SELECT * FROM employee WHERE id = ?1",		
	            nativeQuery = true
	            
	    )
	public List<Employee> findAllByIdExactMatch(@Param("searchPattern") String searchValue);
	  /**
	   * Not Like Match Query Start
	   */
	 
	 @Query(
	            value = "SELECT * FROM employee WHERE first_name NOT LIKE %:searchPattern%",		
	            nativeQuery = true
	            
	    )
	public List<Employee> findAllByFirstNameNotLikeMatch(@Param("searchPattern") String searchValue);
	 @Query(
	            value ="SELECT * FROM employee WHERE last_name NOT LIKE %:searchPattern%",		
	            nativeQuery = true
	            
	    )

	public List<Employee> findAllByLastNameNotLikeMatch(@Param("searchPattern") String searchValue);
	 @Query(
	            value = "SELECT * FROM employee WHERE city NOT LIKE %:searchPattern%",			
	            nativeQuery = true
	            
	    )

	public List<Employee> findAllByCityNotLikeMatch(@Param("searchPattern") String searchValue);
	 @Query(
	            value =  "SELECT * FROM employee WHERE id NOT LIKE %:searchPattern%",			
	            nativeQuery = true
	            
	    )

	public List<Employee> findAllByIdNotLikeMatch(@Param("searchPattern") String searchValue);

}
