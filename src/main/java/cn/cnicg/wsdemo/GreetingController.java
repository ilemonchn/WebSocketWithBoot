package cn.cnicg.wsdemo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by Lemon on 2018/7/13.
 */
@Controller
public class GreetingController {

    private int count = 0;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
//        while (count < 5){
//            Thread.sleep(1000); // simulated delay
//            this.g1();
//            System.out.println(count);
//        }
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/kkkk")
    @SendTo("/topic/greetings")
    public Greeting g1() throws  Exception{
        Thread.sleep(1000);
        count++;
        return new Greeting("hello:my:"+count);
    }



}
