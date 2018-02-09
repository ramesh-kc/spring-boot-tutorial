package com.tutorial.springboot.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.tutorial.springboot.service")
class SpringContextAOP {
	@Bean
	public HiByService hiByService() {
		return new HiByService();
	}
}

@Aspect
@Component
class MyAspect {

	@Before("execution(* com.tutorial.springboot.service.HiByService.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.print("Before ");
		System.out.print(joinPoint.getSignature().getName() + " called with ");
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}
	@AfterReturning(pointcut = "execution(* com.tutorial.springboot.service.HiByService.*(..))", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {
		System.out.print("after ");
		System.out.print(joinPoint.getSignature().getName());
		System.out.println("result is " + result);
	}
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextAOP.class)
public class AopExampleTest {
	@Autowired
	private HiByService service;

	@Test
	public void testSomething() {
		service.sayHi("Ramesh KC");
		service.sayBye();
		service.returnSomething();
	}

}

@Component
class HiByService {
	public void sayHi(String name) {
		System.out.println("Hi " + name);
	}

	public void sayBye() {
		System.out.println("Bye");
	}
	public String returnSomething() {
		return "Hi Bye";
	}
}