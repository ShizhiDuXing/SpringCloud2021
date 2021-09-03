package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController
{
   /* @Value("${config.info}")
    private String configInfo;*/
/*  config:
      label: master #分支名称
      name: config #配置文件名称
      profile: dev #读取后缀名称   上述3个综合：master分支上config-dev.yml的配置文件被读取http://config-3344.com:3344/master/config-dev.yml
      uri: http://localhost:3344 #配置中心地址k*/
  /*  @Value("${spring.cloud.config.uri}")
    private String uri;

    @Value("${spring.cloud.config.label}")
    private String label;
    @Value("${spring.cloud.config. name}")
    private String  name;

    @Value("${spring.cloud.config.profile}")
    private String profile;*/

    //private String configInfo=uri+label+name+profile;
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
