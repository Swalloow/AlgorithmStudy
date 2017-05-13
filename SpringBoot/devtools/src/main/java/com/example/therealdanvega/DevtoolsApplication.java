package com.example.therealdanvega;

import com.example.foo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan({"com.example.foo", "com.example.therealdanvega"})
@SpringBootApplication
public class DevtoolsApplication {

	@Bean
	public User user() {
		return new User("Dan", "Vega");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DevtoolsApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		for(String name : beanNames) {
			System.out.println(name);
		}

		System.out.println(ctx.getBean("user").toString());
	}
}
