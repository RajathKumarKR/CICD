package io.ci.cd.CICD;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ControllerTest {

	/**
	 * Autowired reference for {@link #MockMvc}
	 */
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService service;

	@Autowired
	private EmployeeController controller;

	@Test
	public void getEmployeeTest() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmail("rajath.kr1249@gmail.com");
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		list.add(entity);
		Mockito.when(service.getAllEmployees()).thenReturn(list);
		ResponseEntity<List<EmployeeEntity>> op = controller.getAllEmployees();

		assertEquals(HttpStatus.OK, op.getStatusCode());
	}
}
