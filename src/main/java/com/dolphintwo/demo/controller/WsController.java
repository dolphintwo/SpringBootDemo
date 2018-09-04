package com.dolphintwo.demo.controller;

import com.dolphintwo.demo.websocket.ddMessage;
import com.dolphintwo.demo.websocket.ddResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by dd on 2018/9/3 17:59
 */

@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ddResponse say(ddMessage message)throws Exception{
        Thread.sleep(3000);
        return new ddResponse("welcome"+message.getName()+"!");
    }

}
