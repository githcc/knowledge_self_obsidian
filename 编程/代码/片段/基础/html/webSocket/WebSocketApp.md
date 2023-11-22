```
import javax.servlet.ServletException;
import javax.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;

public class WebSocketApp {

    public static void main(String[] args) {
        Server server = new Server("localhost", 8080, "/websocket", WebSocketServer.class);

        try {
            server.start();
            System.out.println("WebSocket Server started");
            Thread.currentThread().join();
        } catch (DeploymentException | InterruptedException | ServletException e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}

```