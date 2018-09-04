package com.dolphintwo.demo.websocket;

/**
 * Created by dd on 2018/9/3 17:57
 */

public class ddResponse {

    private String responseMessage;

    public ddResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage(){
        return responseMessage;
    }
}
