package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController    //代表这个类适rest风格的控制器，返回json或xml格式的数据
@Controller
public class HelloWorldController {
	@RequestMapping("/hello")   //配置url和方法之间的映射，可以注解在类和方法之上
	@ResponseBody
	public String sayHello() {
		return "Hello,sprng boot goldstine 1111!";
	}
}
