package com.telstra.telstrastockservice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class TelstraStockServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testStockService() throws Exception{
		this.mockMvc.perform(get("/stock/TLS.AX"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testStockJsonResponse() throws Exception{
		this.mockMvc.perform(get("/stock/TLS.AX")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name",
						Matchers.is("Telstra Corporation Limited")));
	}


}
