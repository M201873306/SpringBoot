package com.hust.springbootrabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.hust.springbootrabbitmq.entity.book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;
    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",new book("西游记2","吴承恩2"));

    }
    //接受数据,如何将数据自动的转为json发送出去
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建完成");
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        //创建绑定规则
        //amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
        //amqpAdmin.de
    }
    @Test
    public void createBinding(){

        //amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //System.out.println("创建完成");
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        //创建绑定规则
        //参数：目的地就是绑定到哪个队列，绑定的类型是队列还是交换器，
        //绑定的交换器给哪个交换器绑定，路由件，其他是null
        amqpAdmin.declareBinding(new Binding("atguigu", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
        //amqpAdmin.de
    }
}
