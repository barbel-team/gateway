package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.CartResponse;
import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.Domain.Order;
import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.service.MemberService;
import com.google.gson.Gson;
import java.text.ParseException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
    private static final String PRODUCT_HOSTNAME = "localhost";
    private static final String MEMBER_HOSTNAME = "localhost";

    @Autowired
    MemberService service;

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        Gson gson = new Gson();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = "http://" + PRODUCT_HOSTNAME+ ":4002/products";
        HttpEntity<String> result = template.getForEntity(url, String.class);
        System.out.println(result.getBody());
        Product[] p = gson.fromJson(result.getBody(), Product[].class);
        model.addAttribute("products", p);
        return "index";
    }

    @GetMapping("/products")
    public String detail(@RequestParam long id, Model model) {
        Gson gson = new Gson();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = "http://" + PRODUCT_HOSTNAME+ ":4002/product/?id=" + id;
        System.out.println(url);
        HttpEntity<String> result = template.getForEntity(url, String.class);
        Product p = gson.fromJson(result.getBody(), Product.class);
        model.addAttribute("product", p);
        return "product/productDetail";
    }

    @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String orderProduct(Product product, Model model) {
//        System.out.println(product.getPrd_ment());
//        Order.builder().fk_prd_num((int) product.getUid()).
        model.addAttribute("productId", product.getUid());
        return "member/orderTemp";
    }

    @PostMapping(value = "/orderr", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String orderReal(String res_nm, String res_addr01, String res_addr02, String res_addr03, String res_tel,
                            String deliv_req, int fk_prdnum) {
        Gson gson = new Gson();
        Order order = Order.builder().res_nm(res_nm).res_addr01(res_addr01).res_addr02(res_addr02)
                .res_addr03(res_addr03).res_tel(res_tel).fk_prdnum(fk_prdnum).deliv_req(deliv_req).build();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = "http://" + PRODUCT_HOSTNAME+ ":4002/order";
        String json = gson.toJson(order);
        System.out.println(json);
        HttpEntity<String> result = template.postForEntity(url, order, String.class);
        return "redirect:/";
    }

//
//    @GetMapping("/products")
//    public String productDetail(@RequestParam long id, Model model) {
//        Gson gson = new Gson();
//        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
//        String url = "http://localhost:4002/product/?id=" + id;
//        System.out.println(url);
//        HttpEntity<String> result = template.getForEntity(url, String.class);
//        Product p  = gson.fromJson(result.getBody(), Product.class);
//        model.addAttribute("product", p);
//        return "/product/singleProduct";
//

    @GetMapping("/myCart")
    public String cart(HttpServletRequest request, Model model) {
        Gson gson = new Gson();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = "http://" + PRODUCT_HOSTNAME+ ":4002/mylikes";
        HttpEntity<String> result = template.getForEntity(url, String.class);
        System.out.println(result.getBody());
        CartResponse[] p = gson.fromJson(result.getBody(), CartResponse[].class);
        model.addAttribute("carts", p);
        return "/myPage/myCart";
    }

    @PostMapping("/register")
    public String create(Member m, Model model) throws ParseException {
        System.out.println(m.getUid());
        System.out.println(m.getAddr01());
        Gson gson = new Gson();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = "http://" + MEMBER_HOSTNAME+  ":4001/register";
        String json = gson.toJson(m);
        System.out.println(json);
        HttpEntity<String> result = template.postForEntity(url, m, String.class);

        return "redirect:/";

    }


}
