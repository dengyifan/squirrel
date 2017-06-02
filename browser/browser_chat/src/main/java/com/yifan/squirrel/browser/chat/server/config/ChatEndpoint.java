package com.yifan.squirrel.browser.chat.server.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yifan on 2017/6/1.
 *
 * 源码见：
 * http://svn.apache.org/viewvc/tomcat/tc7.0.x/trunk/webapps/examples/WEB-INF/classes/websocket/chat/ChatAnnotation.java?view=markup
 */
@ServerEndpoint("/chatroom/{roomName}")
public class ChatEndpoint {

    private static final Log log = LogFactory.getLog(ChatEndpoint.class);

    private static final String GUEST_PREFIX = "Guest";

    private static final AtomicInteger connectionIds = new AtomicInteger(0);

    private static final Set<ChatEndpoint> connections = new CopyOnWriteArraySet<ChatEndpoint>();

    private final String nickName;
    private Session session;


    public ChatEndpoint(){
        nickName = GUEST_PREFIX + connectionIds.getAndIncrement();
    }

    @OnOpen
    public void open(Session session, @PathParam("roomName") String roomName){
        log.info("ChatEndpoint open roomName:" + roomName);

        this.session = session;
        connections.add(this);

        String message = String.format("* %s %s", nickName, "has joined.");
        broadcast(message);
    }


    @OnClose
    public void close(Session session, @PathParam("roomName") String roomName) {
        log.info("ChatEndpoint close roomName:" + roomName);
        connections.remove(this);
        String message = String.format("* %s %s",nickName, "has disconnected.");
        broadcast(message);
    }



    @OnMessage
    public void message(Session session,String msg,@PathParam("roomName") String roomName) {
        log.info("ChatEndpoint message roomName: " + roomName + " msg:" + msg);
        String filteredMessage = String.format("%s: %s",nickName, msg);
        broadcast(filteredMessage);

    }

    @OnError
    public void error(Session session,Throwable t){
        log.error("ChatEndpoint Error: " + t.toString(), t);

    }


    private static void broadcast(String msg) {
        for (ChatEndpoint client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                log.debug("ChatEndpoint Error: Failed to send message to client", e);
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String message = String.format("* %s %s",
                        client.nickName, "has been disconnected.");
                broadcast(message);
            }
        }
    }


}
