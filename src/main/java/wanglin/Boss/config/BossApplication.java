package wanglin.Boss.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("wanglin.Boss")
@SpringBootApplication
@MapperScan("wanglin.Boss.mapper")
public class BossApplication {

	public static void main(String[] args) {
		SpringApplication.run(BossApplication.class, args);
	}

}
