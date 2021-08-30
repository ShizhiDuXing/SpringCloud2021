package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class PaymentController
{
   @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

   @PostMapping("/payment/create")
   public CommonResult create(@RequestBody Payment payment){

       int result =paymentService.create(payment);

       if (result > 0){
           return new CommonResult(200,"添加成功！+端口："+serverport,result);
       }else {
           return new CommonResult(404,"插入失败！");
       }
   }

   @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       Payment payment=paymentService.getPaymentById(id);
       log.info("线程结果{}",payment);
       if (payment==null){
           return new CommonResult<>(444,"查询失败！！");
       }else {
           return new CommonResult<>(200,"查询成功！+端口："+serverport,payment);
       }
   }

   @PostMapping("/payment/update")
    public CommonResult update(Payment payment){
       int result =paymentService.update(payment);

       if (result > 0){
           return new CommonResult(200,"更新成功！",result);
       }else {
           return new CommonResult(404,"更新失败！");
       }
   }
}
