package com.neogiciel.spring_kibana;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringKibanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKibanaApplication.class, args);
	}

}
