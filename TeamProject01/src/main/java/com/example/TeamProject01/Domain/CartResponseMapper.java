package com.example.TeamProject01.Domain;


public class CartResponseMapper {
  public static CartResponse mapping(Cart cart, Product product) {
    return CartResponse.builder()
        .id(cart.getId())
        .uid(cart.getUid())
        .ordnum(cart.getOrdnum())
        .amount(cart.getAmount())
        .cart_chk(cart.getCart_chk())
        .cart_pay(cart.getCart_pay())
        .prd_name(product.getPrd_name())
        .prd_pic_url(product.getPrd_img_url()).build();
  }
}
