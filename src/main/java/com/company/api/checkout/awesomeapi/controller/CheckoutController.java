package com.company.api.checkout.awesomeapi.controller;

import static org.springframework.http.MediaType.*;
import com.company.api.checkout.awesomeapi.data.dto.Watch;
import com.company.api.checkout.awesomeapi.service.CheckoutService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {

  private final CheckoutService<List<Watch>> checkoutService;

  @Autowired
  public CheckoutController(CheckoutService<List<Watch>> checkoutService) {
    this.checkoutService = checkoutService;
  }

  @PostMapping(path = "/checkout", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<String> order(@RequestBody List<Watch> body) {
    String result = checkoutService.totalPrice(body);

    return ResponseEntity.ok(result);
  }

}
