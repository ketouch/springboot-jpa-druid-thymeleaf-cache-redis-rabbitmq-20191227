package edu.nustti;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching//开启缓存
@EnableRabbit //开启基于注解的RabbitMQ模式[Springboot2.0后可以不配置]
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
