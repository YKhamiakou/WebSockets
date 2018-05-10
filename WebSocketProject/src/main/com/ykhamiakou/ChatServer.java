package main.com.ykhamiakou;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Server end point class
 */
@ServerEndpoint(value = "/chat")
public class ChatServer {

    /**
     * Logger
     */
    private static final Logger LOGGER =
            Logger.getLogger(ChatServer.class.getName());

    /**
     * Involked when new connection is established
     * @param session - user's session
     */
    @OnOpen
    public void onOpen(Session session) {
        LOGGER.log(Level.INFO, "New connection with client: {0}",
                session.getId());
    }

    /**
     * Involked when new message is received
     * @param message - user's message
     * @param session - user's session
     * @return - server's message
     */
    @OnMessage
    public String onMessage(String message, Session session) {
        LOGGER.log(Level.INFO, "New message from Client [{0}]: {1}",
                new Object[] {session.getId(), message});
        return "Server received [" + message + "]";
    }

    /**
     * Involked when existing connection is closed
     * @param session - user's session
     */
    @OnClose
    public void onClose(Session session) {
        LOGGER.log(Level.INFO, "Close connection for client: {0}",
                session.getId());
    }

    /**
     * Involked when there is error in communication channel
     * @param exception - channel error
     * @param session - user's session
     */
    @OnError
    public void onError(Throwable exception, Session session) {
        LOGGER.log(Level.INFO, "Error for client: {0}", session.getId());
    }

}
