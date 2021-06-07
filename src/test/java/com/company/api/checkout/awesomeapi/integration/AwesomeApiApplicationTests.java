package com.company.api.checkout.awesomeapi.integration;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class AwesomeApiApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  void integrationTestShouldReturnExpectedValueWhenCorrectInput() throws Exception {
    mvc.perform(MockMvcRequestBuilders
        .post(URI.create("www://localhost:8080/checkout"))
        .contentType(
            MediaType.APPLICATION_JSON)
        .content(setMockContent()))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.price", is(380)));
  }

  @Test
  void integrationTestShouldReturnVoidWhenNoItemsInTheList() throws Exception {
    mvc.perform(MockMvcRequestBuilders
        .post(URI.create("www://localhost:8080/checkout"))
        .contentType(
            MediaType.APPLICATION_JSON)
        .content("[]"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.price", is(0)));
  }

  private String setMockContent() {
    return "[\n"
        + "    \"001\",\n"
        + "    \"001\",\n"
        + "    \"001\",\n"
        + "    \"001\",\n"
        + "    \"002\"\n"
        + "]";
  }

}
