package Server;

import java.net.Socket;
import java.util.ArrayList;

public class ArraySockets {

    private static ArrayList<Socket> socketArrayList = new ArrayList<>();

    public static void addNewSocket(Socket socket){
        socketArrayList.add(socket);
    }

    public static ArrayList<Socket> getSocketArrayList(){
        return socketArrayList;
    }
}
