package cg.group4.game_logic.stroll.events.multiplayer_event;

import com.badlogic.gdx.Gdx;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * Host of a multi-player stroll.
 */
public class MultiplayerHost extends Host {

    /**
     * Socket used to accept incoming connection.
     */
    ServerSocket cServerSocket;

    /**
     * Creates a new MultiplayerHost that has a ServerSocket bound to a random open port.
     */
    public MultiplayerHost() {
        try {
            cServerSocket = new ServerSocket(0);
            cServerSocket.setSoTimeout(cFiveMinutes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Socket createSocket() {
        try {
            return cServerSocket.accept();
        } catch(SocketTimeoutException e) {
            stopHosting();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the port on which the ServerSocket is listening.
     * @return The port.
     */
    public int getPort() {
        return cServerSocket.getLocalPort();
    }

    /**
     * Clears the ServerSocket.
     */
    public void stopHosting() {
        try {
            cServerSocket.close();
            Gdx.app.debug("MultiplayerHost", "Closed the ServerSocket");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isHost() {
        return true;
    }
}
