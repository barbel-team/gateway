package com.example.TeamProject01.Domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class CartResponse {
  public int id;
  public long uid;
  public long ordnum;
  public int amount;
  public int cart_chk;
  public int cart_pay;
  public String prd_name;
  public String prd_pic_url;
}
