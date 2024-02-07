package com.generation.javazon;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.javazon.entities.Employee;
import com.generation.javazon.repositories.EmployeeRepository;

@SpringBootTest
class JavazonApplicationTests {

	@Autowired
	EmployeeRepository repo;

	@Test
	void contextLoads() {

		Employee e = new Employee();
		e.setName("Federico");
		e.setSurname("Galuppi");
		e.setAddress("locker9662@gmail.com");
		e.setRole("CEO");
		e.setImgUrl(
				"https://www.svgrepo.com/show/382100/female-avatar-girl-face-woman-user-7.svg");
		e.setDob(LocalDate.parse("1996-11-24"));
		e.setHiredOn(LocalDate.parse("2024-02-02"));
		e.setSecurityLevel(5);
		e.setSalary(5000);
		repo.save(e);
	}

}
