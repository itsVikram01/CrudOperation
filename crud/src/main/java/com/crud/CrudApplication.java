package com.crud;

import com.crud.model.Employee;
import com.crud.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		System.out.println("Started..................!!!!!!!");
	}

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setFirstName("Vikram");
		emp.setLastName("kumar");
		emp.setEmailId("asdf@gmail.com");
		employeeRepo.save(emp);

		Employee emp1 = new Employee();
		emp1.setFirstName("Vikash");
		emp1.setLastName("kumar");
		emp1.setEmailId("qwerty@gmail.com");
		employeeRepo.save(emp1);
	}
}
