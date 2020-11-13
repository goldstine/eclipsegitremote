package com.example.demo;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Data    //自动生成setter，Getter、toString、equals、hashCode方法，以及不带参数的构造方法
@Component  //声明此类是spring管理类，它常用在无法使用service,Repository描述的spring管理类上，相当与通用的注解
@ConfigurationProperties(prefix="com.example.demo")   //注入application.properties中的配置项
public class CoExample {
	
	private String name;
	
	private int age;
	
	private List<String>address;
	
}
