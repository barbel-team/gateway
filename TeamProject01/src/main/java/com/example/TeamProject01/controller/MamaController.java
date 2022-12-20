package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.service.MemberService;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registers")
public class MamaController {

        Logger logger = LoggerFactory.getLogger(com.example.TeamProject01.controller.RegisterController.class);
        @Autowired
        MemberService service;

        @PostMapping("")
        public Member create(@RequestBody Member m) throws ParseException {
            System.out.println(m.toString());
            System.out.println(m.getAddr01());
            service.save(m);

            return m;
        }

    }
