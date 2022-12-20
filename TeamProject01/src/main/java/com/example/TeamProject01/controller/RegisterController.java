package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.CartResponse;
import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.service.MemberService;
import com.google.gson.Gson;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/register")
public class RegisterController {
    Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    MemberService service;

    @Autowired
    public RegisterController(MemberService service) {
        this.service = service;
    }



    @ResponseBody
    @GetMapping("/idcheck")
    public int idchecked(@RequestParam("id") String id){
        int data = service.idCheck(id);
        return data;
    }

    @ResponseBody
    @GetMapping("/nicknameCheck")
    public int nicknameCheck(@RequestParam("nickname") String n_name) {
        int data = service.nicknameCheck(n_name);
        return data;
    }

    @ResponseBody
    @GetMapping("/mailCheck")
    public int emailCheck(@RequestParam("mail") String email) {
        int data = service.emailCheck(email);
        return data;
    }

}
