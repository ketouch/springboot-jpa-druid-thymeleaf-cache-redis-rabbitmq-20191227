package edu.nustti;

import edu.nustti.entity.Student;
import edu.nustti.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {
    @Autowired
    StringRedisTemplate stringRedisTemplate;//k-v都是 string 主要用来操作字符串

    @Autowired
    RedisTemplate redisTemplate;//k-v  主要用来操作对象

    @Autowired
    RedisTemplate<Object, Object> teacherRedisTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void createExchage(){
        //1.创建交换器
        //amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        //2.创建队列
        //amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        //3.创建绑定规则
        //amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqpAdmin.queue",null));
        //4.各种删除
        //amqpAdmin.deleteExchange("name");
        //amqpAdmin.deleteQueue("name");

    }

    @Test//测试Redis模板stringRedisTemplate
    void test01(){
        //stringRedisTemplate.opsForValue().append("springboot","2019-12-28");
        String str = stringRedisTemplate.opsForValue().get("springboot");
        System.out.println("str="+str);
    }

    @Test//测试Redis模板redisTemplate
    void test02(){
        Teacher teacher = new Teacher();
        teacher.setId(4);
        teacher.setName("Jack");
        teacher.setPhone("15161012908");
        teacher.setEmail("ketouch@qq.com");
        //redisTemplate.opsForValue().set("teacher",teacher);//特别注意这个类需要可序列化Serializable
        teacherRedisTemplate.opsForValue().set("teacher",teacher);
    }

    @Test//测试RabbitMQ发送消息(单播 点对点)
    void test03(){
        //object默认被当作消息体，只需要传入发送的对象，自动序列化发送给RabbitMq
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个news");
        map.put("data", Arrays.asList("abc",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","lemonccc.news",map);
    }

    @Test//测试RabbitMQ发送消息(广播)
    void test03_1(){
        //object默认被当作消息体，只需要传入发送的对象，自动序列化发送给RabbitMq
        Student student = new Student("章三",77);
        rabbitTemplate.convertAndSend("exchange.direct","lemonccc.news",student);
    }


    /**
     * //测试RabbitMQ接收消息(单播 点对点)
     * 但是对象消息默认使用JDK方式序列化
     * 如何使用JSON形式序列化？配置一个MessageConverter
     */
    @Test
    void test04(){
        Object o = rabbitTemplate.receiveAndConvert("lemonccc.news");
        System.out.println(o);
    }




    @Test
    void contextLoads() {

    }

}
