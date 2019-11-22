/*
 Author by Ravishankar 
 */
package com.societegeneral.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.societegeneral.model.SocgenEmployee;


@Repository
public interface SocgenEmployeerepository extends CrudRepository<SocgenEmployee, Integer> , JpaRepository<SocgenEmployee, Integer>
{
	/*getting all employees in asc order firstname */
	List<SocgenEmployee> findByOrderByFirstNameAsc();
}
