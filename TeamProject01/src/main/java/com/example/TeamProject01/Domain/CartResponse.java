package com.barbel.product_service.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class CartResponse {
  private int id;
  private long uid;
  private long ordnum;
  private int amount;
  private int cart_chk;
  private int cart_pay;
  private String prd_name;
  private String prd_pic_url;
}
