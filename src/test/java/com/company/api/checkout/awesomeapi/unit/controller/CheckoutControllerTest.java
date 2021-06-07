package com.company.api.checkout.awesomeapi.unit.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.company.api.checkout.awesomeapi.controller.CheckoutController;
import com.company.api.checkout.awesomeapi.data.dto.Watch;
import com.company.api.checkout.awesomeapi.service.CheckoutService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@WebMvcTest(CheckoutController.class)
class CheckoutControllerTest {

  @Autowired
  private CheckoutController controller;
  @MockBean
  private CheckoutService service;

  private static final String EXPECTED_JSON = "{ \"price\": 550 }";

  @Test
  void orderShouldWorkAsExpectedWhenInputIsCorrect() {
    // given
    given(service.totalPrice(any())).willReturn(EXPECTED_JSON);
    List<Watch> mock = mockData();

    // when
    ResponseEntity<String> response = controller.order(mock);

    // then
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(EXPECTED_JSON, response.getBody());
  }

  private List<Watch> mockData() {
    List<Watch> watches = new ArrayList<>();
    watches.add(new Watch("001"));
    watches.add(new Watch("001"));
    watches.add(new Watch("001"));
    watches.add(new Watch("001"));
    watches.add(new Watch("002"));
    watches.add(new Watch("002"));
    watches.add(new Watch("002"));
    watches.add(new Watch("003"));
    return watches;
  }
}