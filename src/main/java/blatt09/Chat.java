package blatt09;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.server.ServerEndpointConfig;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

@ServerEndpoint("/numericalchat")
public class Chat extends ServerEndpointConfig.Configurator{
    private Random random = new Random();
    private static Set<Session> sessions;
    @OnOpen
    public void onOpen(Session session) {
        sessions = session.getOpenSessions();
        System.out.println("New connexion from: "+ session.getId());
    }



    @OnMessage
    public void onMessage(String message, Session session){
        for(Session ss : session.getOpenSessions())
            ss.getAsyncRemote().sendText(message);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason){
        System.out.println("Connexion closed "+reason);
         sessions.remove(session);
    }

    @OnError
    public void onError(Throwable e){
        e.printStackTrace();
    }
}/*

https://technology.amis.nl/software-development/java-web-application-sending-json-messages-through-websocket-to-html5-browser-application-for-real-time-push/

*/