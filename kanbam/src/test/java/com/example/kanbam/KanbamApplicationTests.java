package com.example.kanbam;

import com.example.kanbam.pojo.Priority;
import com.example.kanbam.pojo.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class KanbamApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(mockMvc);
	}

	@Test
	public void testShowKanbanBoard() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/");

		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful())
				.andExpect(model().attributeExists("tasks"))
				.andExpect(model().attribute("tasks", (Object) new ArrayList<>()));
	}

	@Test
	public void testSubmitTask() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/SubmitTask")
				.param("name", "Tarefa 1")
				.param("description", "Tarefa teste")
				.param("status", Status.TODO.name())
				.param("priority", Priority.HIGH.name())
				.param("createDate", LocalDate.now().toString());

		mockMvc.perform(request)
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"));
	}

	@Test
	public void testGetTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/task/?123");

		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful())
				.andExpect(model().attributeExists("task"))
				.andExpect(view().name("task"));
	}

	@Test
	public void testGetKanbanForm() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/form");

	}
}
