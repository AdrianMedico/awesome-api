package com.company.api.checkout.awesomeapi.unit.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.company.api.checkout.awesomeapi.data.dto.Watch;
import com.company.api.checkout.awesomeapi.service.CheckoutServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(CheckoutServiceImpl.class)
class CheckoutServiceImplTest {

  @Autowired
  private CheckoutServiceImpl service;

  private static final String EXPECTED_JSON = "{ \"price\": 550 }";

  @Test
  void totalPriceShouldReturnExpectedSum() throws JSONException {
    // given
    List<Watch> watches = mockData();
    // when
    String result = service.totalPrice(watches);
    // then
    JSONAssert.assertEquals(EXPECTED_JSON, result, false);
  }

  @Test
  void totalPriceShouldReturnExpectedResultWhenIncludesNullItem() throws JSONException {
    // given
    List<Watch> watches = mockData();
    watches.add(null);
    // when
    String result = service.totalPrice(watches);
    // then
    JSONAssert.assertEquals(EXPECTED_JSON, result, false);
  }

  @Test
  void totalPriceShouldRaiseException() {
    // given
    List<Watch> watches = null;

    assertThatThrownBy(() -> service.totalPrice(watches))
        .isInstanceOf(IllegalArgumentException.class);
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