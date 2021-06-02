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
			  value = "SELECT * FROM employee WHERE first_name LIKE %:searchPatternFN% OR (last_name LIKE %:searchPatternLN%) OR (city LIKE %:searchPatternCity%) OR ( id LIKE %:searchPatternId%)OR ( type LIKE %:searchPatternType%)",  
	            nativeQuery = true
	            
	            
	            
	    )
	  
	  public List<Employee> findAllBySearchValue( @Param("searchPatternFN") String searchPatternFN,@Param("searchPatternLN") String searchPatternLN, @Param("searchPatternCity") String searchPatternCity, @Param("searchPatternId") String searchPatternId,@Param("searchPatternType") String searchPatternType); 
	  
	

	  
	  /**
	   * Exact Match Query Start
	   */
	  
	  @Query(
			  value = "SELECT * FROM employee WHERE  first_name = :searchPatternFN OR (last_name = :searchPatternLN) OR (city = :searchPatternCity) OR (id = :searchPatternId ) OR (type = :searchPatternType)",  
	            nativeQuery = true
	            
	            
	    )
	  
	  public List<Employee> findAllByExactSearch( @Param("searchPatternFN") String searchPatternFN,@Param("searchPatternLN") String searchPatternLN, @Param("searchPatternCity") String searchPatternCity, @Param("searchPatternId") String searchPatternId,@Param("searchPatternType") String searchPatternType); 
	  

  /**
	   * Not Like Match Query Start
	   */
	 
	 @Query(
			 value = "SELECT * FROM employee WHERE first_name NOT LIKE %:searchPatternFN% OR (last_name NOT LIKE %:searchPatternLN%) OR (city NOT LIKE %:searchPatternCity%) OR ( id NOT LIKE %:searchPatternId%)OR ( type NOT LIKE %:searchPatternType%)",  
	            nativeQuery = true
	            
	    )
	public List<Employee> findAllByNotLikeMatch(@Param("searchPatternFN") String searchPatternFN,@Param("searchPatternLN") String searchPatternLN, @Param("searchPatternCity") String searchPatternCity, @Param("searchPatternId") String searchPatternId,@Param("searchPatternType") String searchPatternType); 
	  

}
