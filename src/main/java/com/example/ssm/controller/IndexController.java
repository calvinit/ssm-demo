package com.example.ssm.controller;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@Api(tags = "首页控制器")
@Controller
@RequestMapping
public class IndexController {

    @ApiIgnore
    @ApiOperation(value = "首页")
    @GetMapping
    public String index() {
        return "index";
    }

    @ApiOperation(value = "返回纯字符串")
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @ApiOperation(value = "测试日期 json 返回")
    @GetMapping("/date/test")
    @ResponseBody
    public Map<String, Object> testDate() {
        Map<String, Object> map = Maps.newHashMap();

        map.put("java.util.Date", new java.util.Date());
        map.put("java.sql.Date", new java.sql.Date(System.currentTimeMillis()));
        map.put("java.time.LocalDate", java.time.LocalDate.now());
        map.put("java.time.LocalTime", java.time.LocalTime.now());
        map.put("java.time.LocalDateTime", java.time.LocalDateTime.now());

        return map;
    }
}
