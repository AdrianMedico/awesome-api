package com.company.api.checkout.awesomeapi.controller;

import static org.springframework.http.MediaType.*;

import com.company.api.checkout.awesomeapi.data.dto.CheckoutAmount;
import com.company.api.checkout.awesomeapi.data.dto.Watch;
import com.company.api.checkout.awesomeapi.service.CheckoutService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/", produces = APPLICATION_JSON_VALUE)
public class CheckoutController {

  private final CheckoutService checkoutService;

  @Autowired
  public CheckoutController(CheckoutService checkoutService) {
    this.checkoutService = checkoutService;
  }

  @PostMapping(path = "checkout", consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<CheckoutAmount> order(@RequestBody List<Watch> body) {

    final CheckoutAmount result = checkoutService.totalPrice(body);

    log.info("checkout amount created");
    return ResponseEntity.ok(result);
  }

}
