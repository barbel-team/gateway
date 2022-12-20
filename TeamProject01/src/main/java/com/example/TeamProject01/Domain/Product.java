package com.example.TeamProject01.Domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    // 상품명
    @NotBlank(message = "상품명을 입력해주세요")
    private String prd_name;

    // 상품가격 : Int 변수는 꼭 NotBlank가 아닌 NotNull을 써야 함!
    @NotNull
    private int prd_price;

    private int fk_cate;

    // 상품업체
    @NotBlank(message = "상품 업체를 입력해주세요")
    private String prd_cmp;

    // 상품종류
    @NotBlank(message = "상품 종류를 입력해주세요")
    private String prd_type;

    // 상품 내용
    @NotBlank(message = "상품 내용을 입력해주세요")
    private String prd_ment;
    @Column(name = "prd_img")
    private String prd_img_url;

    // 판매 수량
    @NotNull
    private int prd_sales;

    @Builder
    private Product(
            String prd_name,
            int prd_price,
            String prd_cmp,
            String prd_type,
            String prd_ment,
            String prd_img_url,
            int prd_sales) {
        this.prd_name = prd_name;
        this.prd_price = prd_price;
        this.prd_cmp = prd_cmp;
        this.prd_type = prd_type;
        this.prd_ment = prd_ment;
        this.prd_sales = prd_sales;
        this.prd_img_url = prd_img_url;
    }
}
