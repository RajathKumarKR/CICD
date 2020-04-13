package io.ci.cd.CICD;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository repo;
	
	
	@Test()
	public void getEmployeeServiceTest() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmail("rajath.kr1249@gmail.com");
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		list.add(entity);
		Mockito.when(repo.findAll()).thenReturn(list);
		List<EmployeeEntity> op=service.getAllEmployees();
		assertEquals(op.get(0).getEmail(),"rajath.kr1249@gmail.com");

	}
	
	@Test()
	public void getEmployeeServiceTest2() {
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		Mockito.when(repo.findAll()).thenReturn(list);
		List<EmployeeEntity> op=service.getAllEmployees();
	}

}
