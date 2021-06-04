package com.company.api.checkout.awesomeapi.service;

import com.company.api.checkout.awesomeapi.data.dto.CheckoutAmount;
import com.company.api.checkout.awesomeapi.data.dto.Watch;
import java.util.List;

public interface CheckoutService {

  CheckoutAmount totalPrice(List<Watch> watches);

}
