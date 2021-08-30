package com.atguigu.springcloude.service.impl;

import com.atguigu.springcloude.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    @GetMapping("/payment/histrix/ok/{id}")
    public String Payment_ok(Integer id) {
        return "正常访问处理线程为:"+Thread.currentThread().getName()+"id:"+id;
    }

    @Override
    @GetMapping(value = "/payment/histrix/no/{id}")
    /*@HystrixCommand(fallbackMethod = "Payment_no_solve")*/
    public String Payment_no(Integer id) {

        int i=10/0;
        return "正常访问处理线程为:"+Thread.currentThread().getName()+"id:"+id;
    }

   /* public String Payment_no_solve(@PathVariable("id") Integer id){
        return "对不起,您访问的网址查询问题o(╥﹏╥)o"+Thread.currentThread().getName();
    }*/
}
