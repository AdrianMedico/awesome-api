package com.company.api.checkout.awesomeapi.service;

import com.company.api.checkout.awesomeapi.data.dto.CheckoutAmount;
import com.company.api.checkout.awesomeapi.data.dto.Watch;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

  @Override
  public CheckoutAmount totalPrice(List<Watch> watches) {
    CheckoutAmount amount = new CheckoutAmount();

    return amount;
  }

  private List<Watch> marshallJson(String json) throws JsonProcessingException {

    ObjectMapper objectMapper = new ObjectMapper();

    List<Watch> watches = objectMapper.readValue(json, new TypeReference<List<Watch>>() {});

    return watches;
  }

  private void splitItemsById(List<Watch> watches) {

  }

}
