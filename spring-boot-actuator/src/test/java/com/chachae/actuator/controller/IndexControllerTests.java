package com.chachae.actuator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author chachae
 * @since 2020/1/8 15:58
 */
@SpringBootTest
public class IndexControllerTests {

  private MockMvc mvc;

  @BeforeEach
  public void setUp() {
    mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
  }

  @Test
  public void getArg() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/index/get/1").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
  }
}
