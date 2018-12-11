package org.zcm.julysso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bruce Zhong
 */

@MapperScan("org.zcm.julysso.dao")
@SpringBootApplication
public class JulyssoApplication {
	public static void main(String[] args) {
		SpringApplication.run(JulyssoApplication.class, args);
	}
}
