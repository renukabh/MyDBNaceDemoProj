package com.db.clm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.db.clm.model.Nace;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NaceRestControllerTests {

	private static MediaType MEDIA_TYPE_JSON;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUpJsonMediaType() {
		MEDIA_TYPE_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(),
				Charset.forName("utf8"));

	}

	@Test
	public void whenPostHttpRequesttoNace_thenStatusOK() throws Exception {
		Nace nace = new Nace();
		nace.setLevel(1);
		nace.setCode("A");
		nace.setDescription("AGRICULTURE, FORESTRY AND FISHING");
		nace.setReferenceRev("A");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = objectWriter.writeValueAsString(nace);

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/createNace").contentType(MEDIA_TYPE_JSON).content(requestJson))

				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void whenGetHttpRequesttoNace_thenStatusOK() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/getAllnace").contentType(MEDIA_TYPE_JSON))

				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	//
	@Test
	public void whenGetHttpRequestNaceById_thenStatusOK() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/getNace/398485").contentType(MEDIA_TYPE_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}
}
