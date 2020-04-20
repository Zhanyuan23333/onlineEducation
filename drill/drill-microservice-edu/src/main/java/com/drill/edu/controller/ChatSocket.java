package com.drill.edu.controller;


import com.drill.edu.entity.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat/{cid}")
@RestController
public class ChatSocket {


    private Integer cid;


    //定义一个全局变量集合sockets,用户存放每个登录用户的通信管道
    private static Map<String, ChatSocket> clients = new ConcurrentHashMap<>();

    //定义一个全局变量Session,用于存放登录用户
    private Session session;

    /**
     *@OnOpen注解
     *注解下的方法会在连接建立时运行
     */
    @OnOpen
    public void open(@PathParam("cid") Integer cid, Session session){
        System.out.println("建立了一个socket通道" + cid);
        this.session = session;
        this.cid = cid;
     //   this.session = session;
        //将当前连接上的用户session信息全部存到scokets中
        clients.put(session.getId(), this);
    }

    /**
     *@OnMessage注解
     *注解下的方法会在前台传来消息时触发
     */
    @OnMessage
    public void getmes(String message, @PathParam("cid") Integer cid) throws IOException {

        this.cid = cid;


        System.out.println("服务器消息:" + message);

        this.sendByCid(message,cid);


    }

    private void sendByCid(String message, Integer cid) {

        for (ChatSocket item: clients.values()) {
     //       System.out.println(item.cid+"----------"+this.cid);
            if(item.cid == cid){
                item.session.getAsyncRemote().sendText(message);
            }
         //   sessionEntry.getValue().
            // getAsyncRemote().sendText(message);
        }


    }

    /**
     *@OnClose注解
     *注解下的方法会在连接关闭时运行
     */
    @OnClose
    public void close(Session session){
        //移除退出登录用户的通信管道
        clients.remove(session.getId());
        System.out.println(session.getId()+"退出了会话！");

    }


    /**
     *广播消息
     */
    public void broadcast(Set<ChatSocket> sockets , String msg) throws IOException {
        //遍历当前所有的连接管道，将通知信息发送给每一个管道
        for(ChatSocket socket : sockets){
            try {
                //通过session发送信息
                System.out.println("发送给管道"+socket.session.getId());
                socket.session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
