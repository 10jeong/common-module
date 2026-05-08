package com.yeoljeong.tripmate.event.enums;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductTopic {
  public static final String STOCK_DEDUCT_FAILED_TOPIC = "product.stock.deduct.failed";
}
