package com.example.demo;
//不知道错在哪
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoExampleTest {
	@Autowired
	private CoExample coExample;
	@Test
	public void getName() {
		//System.out.println(coExample.getName());
	}
	@Test
	public void getAge() {
		//System.out.println(coExample.getAge());
	}
	@Test
	public void getAddress() {
		//System.out.println(coExample.getAddress());
	}
}
