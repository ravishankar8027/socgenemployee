
/*
 Author by Ravishankar 
 */
package com.societegeneral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import junit.framework.TestCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.societegeneral.model.SocgenEmployee;
import com.societegeneral.repository.SocgenEmployeerepository;

@SpringBootTest
class SocietegeneralApplicationTests  extends TestCase{

	
	@Autowired
	com.societegeneral.service.SocgenEmployeeservice  SocgenEmployeeservice;
	
	@Autowired
	SocgenEmployeerepository socgenEmployeerepository ; 
	
	@Test
	void contextLoads() {
	}

	
	/*registering employee*/
	protected void setUp() {

		 SocgenEmployee SocgenEmployee = new SocgenEmployee();
		 SocgenEmployee.setFirstName("Ravishankar");
		 SocgenEmployee.setLastName("NM");
		 SocgenEmployee.setDepartment("CS");
		 SocgenEmployee.setGender("Male");
		 try {
			SocgenEmployee.setDob(new SimpleDateFormat("MM/dd/yyyy").parse("11/25/1990"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 SocgenEmployeeservice.createsocgenemployee(SocgenEmployee);
		 
		 SocgenEmployee emp = new SocgenEmployee();
		 emp.setFirstName("shivaprasad");
		 emp.setLastName("NM");
		 emp.setDepartment("CS");
		 emp.setGender("Male");
		 try {
			emp.setDob(new SimpleDateFormat("MM/dd/yyyy").parse("12/01/1987"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 SocgenEmployeeservice.createsocgenemployee(emp);
		 
		}

	/*fetching employee in asc order firstname*/
	@Test
	void getEmployeesslist() {
		setUp();
		// TODO Auto-generated method stub
	List<SocgenEmployee> list = SocgenEmployeeservice.getEmployeesslist();
	}
}
