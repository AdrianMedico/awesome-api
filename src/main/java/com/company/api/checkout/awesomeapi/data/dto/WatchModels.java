package com.company.api.checkout.awesomeapi.data.dto;

import lombok.Getter;

public enum WatchModels {
  ROLEX("001", 100, 3, 200),
  MICHAEL_KORS("002", 80, 2, 120),
  SWATCH("003", 50),
  CASIO("004", 30);

  @Getter
  private final String id;
  @Getter
  private final int price;
  @Getter
  private final int watchesUntilDiscount;
  @Getter
  private final int promoPrice;

  WatchModels(String id, int price) {
    this.id = id;
    this.price = price;
    this.watchesUntilDiscount = 1;
    this.promoPrice = price;
  }

  WatchModels(String id, int price, int watchesUntilDiscount, int promoPrice) {
    this.id = id;
    this.price = price;
    this.watchesUntilDiscount = watchesUntilDiscount;
    this.promoPrice = promoPrice;
  }
}
