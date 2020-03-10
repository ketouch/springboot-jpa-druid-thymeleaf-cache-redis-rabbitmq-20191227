package edu.nustti.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LemonCCC
 * @description
 * @create 2020/1/3  21:48
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public MessageConverter messageConverter() {
        //把默认的JDKConverter换成 Json的Converter
        return new Jackson2JsonMessageConverter();
    }
}
