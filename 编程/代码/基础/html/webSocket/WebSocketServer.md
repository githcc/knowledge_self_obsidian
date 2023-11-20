```
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket connection opened: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Received message from " + session.getId() + ": " + message);

        // 处理收到的消息，可以在这里实现你的逻辑

        // 这里简单地将收到的消息广播给所有连接的客户端
        for (Session s : session.getOpenSessions()) {
            if (s.isOpen()) {
                s.getAsyncRemote().sendText(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket connection closed: " + session.getId());
    }
}

```