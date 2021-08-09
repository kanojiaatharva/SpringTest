package com.ak.MyApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MyApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
    private GreetingController greetingController;
	
		
	@Test
    public void testgreeting() throws Exception {

        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("test{\"id\":1,\"content\":\"Hello, World!\"}"));
      
    }

}
