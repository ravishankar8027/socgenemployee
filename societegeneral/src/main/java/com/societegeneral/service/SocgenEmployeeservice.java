/*
 Author by Ravishankar 
 */

package com.societegeneral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.societegeneral.model.SocgenEmployee;

@Service
public class SocgenEmployeeservice {

	@Autowired
	com.societegeneral.repository.SocgenEmployeerepository SocgenEmployeerepository ;

	/*getting all the employees with asc order with firstname*/
	public List<SocgenEmployee> getEmployeesslist() {
		return SocgenEmployeerepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}

	public SocgenEmployee createsocgenemployee(SocgenEmployee socgenEmployee) {
		return SocgenEmployeerepository.save(socgenEmployee);
	}
	
}
