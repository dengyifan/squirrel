package com.yifan.squirrel.browser.chat.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by yifan on 2017/6/1.
 */
@ServerEndpoint("/chatroom")
public class ChatEndpoint {

    Logger logger = LoggerFactory.getLogger(ChatEndpoint.class);

    @OnOpen
    public void open(Session session){
        logger.info("ChatEndpoint open roomName:" );
    }

    @OnMessage
    public void message(Session session,String msg) {
        try{

            logger.info("ChatEndpoint message roomName: "  + " msg:" + msg);
            for(Session curSession : session.getOpenSessions()) {
                if(curSession.isOpen()){
                    curSession.getBasicRemote().sendText(" : "+msg);
                }
            }
        }catch(IOException ie){
            logger.error(ie.getStackTrace().toString());
        }

    }


    @OnClose
    public void close(Session session) {
        logger.info("ChatEndpoint close roomName:");
    }
}
