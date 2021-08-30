package com.atguigu.springcloude.controller;

import com.atguigu.springcloude.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @GetMapping("/provider/histrix/ok/{id}")
    public String payment_OK_Controller(@PathVariable("id") Integer id){
        String payment_ok = paymentService.Payment_ok(id);
        return payment_ok;
    }
    @GetMapping("/provider/histrix/on/{id}")
    public String payment_NO_Controller(@PathVariable("id") Integer id){
        String payment_no = paymentService.Payment_no(id);
        return payment_no;
    }
}
