package com.maltem.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maltem.model.Message;
import com.maltem.model.RequestDetailMessage;
import com.maltem.model.ResponseDetailMessage;
import com.maltem.service.impl.TaskServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = com.maltem.BatchUpdateMaltemApplication.class)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataControllerTest {

	@Autowired
	private MockMvc springMockMvc;

	@Mock
	private TaskServiceImpl taskServiceMock;

	@InjectMocks
	private DataController dataController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		springMockMvc = MockMvcBuilders.standaloneSetup(dataController).build();
	}

	@Test
	public void testUpdateTask() throws Exception {
		Message message1 = new Message("test1", "test1 world!", 1548761716001L);
		Message message2 = new Message("test2", "test2 world!", 1548761716002L);
		RequestDetailMessage requestDetailMessage = new RequestDetailMessage();
		List<Message> messageList = new ArrayList<Message>();
		requestDetailMessage.setSource("gitters");
		requestDetailMessage.setTimestamp(new Date().getTime());
		messageList.add(message1);
		messageList.add(message2);
		requestDetailMessage.setUpdates(messageList);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(requestDetailMessage);

		when(taskServiceMock.updateMessage(requestDetailMessage)).thenReturn(true);
		springMockMvc.perform(post("/updateTask")
				.accept(MediaType.APPLICATION_JSON)
	            .contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json; charset=UTF-8"));
	}

	@Test
	public void testGetData() throws Exception {
		ResponseDetailMessage responseDetailMessage = new ResponseDetailMessage();
		Message message1 = new Message("test1", "test1 world!", 1548761716001L);
		List<Message> messageList = new ArrayList<Message>();
		responseDetailMessage.setStatus("success");
		responseDetailMessage.setTimeStamp(new Date().getTime());
		messageList.add(message1);
		responseDetailMessage.setUpdates(messageList);
		String startTime = "20190129220300";
		String endTime = "20190129222000";

		when(taskServiceMock.getMessage(startTime, endTime)).thenReturn(responseDetailMessage);
		springMockMvc.perform(get("/startDate/"+startTime+"/endDate/"+endTime))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json; charset=UTF-8"))
				.andExpect(jsonPath("$.status",is("success")))
				.andExpect(jsonPath("$.updates",hasSize(1)))
				.andExpect(jsonPath("$.updates[0].name",is("test1")));
		verify(taskServiceMock, times(1)).getMessage(startTime, endTime);
	}
}
