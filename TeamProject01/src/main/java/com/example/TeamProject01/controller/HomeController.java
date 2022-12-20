package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Cart;
import com.example.TeamProject01.Domain.CartResponse;
import com.example.TeamProject01.Domain.CartResponseMapper;
import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.service.MemberService;
import com.google.gson.Gson;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
    @Autowired
    MemberService service;
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        Gson gson = new Gson();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = "http://localhost:8080/products";
        HttpEntity<String> result = template.getForEntity(url, String.class);
        System.out.println(result.getBody());
        Product[] p  = gson.fromJson(result.getBody(), Product[].class);
        model.addAttribute("products", p);
        return "index";
    }



    @GetMapping("/myCart")
    public String cart(HttpServletRequest request, Model model) {
        return "/myPage/myCart";
    }

    @PostMapping("/register")
    public String create(Member m, Model model) throws ParseException {
        System.out.println(m.getUid());
        System.out.println(m.getAddr01());
        Gson gson = new Gson();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = "http://localhost:8080/registers";
        String json = gson.toJson(m);
        System.out.println(json);
        HttpEntity<String> result = template.postForEntity(url, m,String.class);

        return "redirect:/";

    }


    @GetMapping("/myOrder")
    public String order(HttpServletRequest request, Model model) {
        return "/myPage/myOrder";
    }

    @GetMapping("/myLike")
    public String like(HttpServletRequest request, Model model) {
        return "/myPage/myLike";
    }


    @GetMapping("/myInquiry")
    public String inquiry(HttpServletRequest request, Model model) {
        return "/myPage/myInquiry";
    }

    @GetMapping("/myReview")
    public String review(HttpServletRequest request, Model model) {
        return "/myPage/myReview";
    }
}
