package com.company.api.checkout.awesomeapi.service;

public interface CheckoutService<A, R> {

  R totalPrice(A watches);

}
