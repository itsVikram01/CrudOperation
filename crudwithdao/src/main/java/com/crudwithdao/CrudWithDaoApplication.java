package com.crudwithdao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@EntityScan
@SpringBootApplication
@EnableJpaRepositories
public class CrudWithDaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudWithDaoApplication.class, args);
		System.out.println("Started..................!!!!!!!");
	}

	/*@Autowired
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
	}*/
}
