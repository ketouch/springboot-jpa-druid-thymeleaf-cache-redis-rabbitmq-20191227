package edu.nustti.service;

import edu.nustti.entity.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author LemonCCC
 * @description
 * @create 2020/1/3  22:06
 */
@Service
public class StudentService {
    //监听指定在某个或某几个消息队列并获取信息
    @RabbitListener(queues = {"lemonccc.news"})
    public void receive(Student student){
        //发现使用测试往消息队列里发送数据的时候，这个监听也会启动
        System.out.println("测试没有开启项目:"+student);
    }
}
