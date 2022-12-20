package com.barbel.product_service.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cart_prd")
public class Cart {
  @Id
  @Column(name = "uid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "fk_member")
  private long uid;
  @Column(name = "fk_ord")
  private long ordnum;
  private int amount;
  private int cart_chk;
  private int cart_pay;

  @Builder
  private Cart(
      int id,
      long uid,
      long ordnum,
      int amout,
      int cart_chk,
      int cart_pay) {
    this.id = id;
    this.uid = uid;
    this.ordnum = ordnum;
    this.amount = amout;
    this.cart_chk = cart_chk;
    this.cart_pay = cart_pay;
  }
}
