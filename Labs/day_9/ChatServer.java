import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer
{
ServerSocket serverSocket;
public ChatServer()
{
    try 
    {
        serverSocket = new ServerSocket(5005);
    }
    catch(Exception e)
    {
    }

     try
      {  while(true)
            {
            Socket s = serverSocket.accept();
            new ChatHandler(s);
            }
        }
        catch(Exception e)
        {
        }
}
public static void main(String[] args)
{
    System.out.println("Server is running...");
    new ChatServer();
}
}

class ChatHandler extends Thread
{
DataInputStream dis;
PrintStream ps;
static Vector<ChatHandler> clientsVector =
new Vector<ChatHandler>();
public ChatHandler(Socket cs)
{
        System.out.println("Connection established...");
        try{
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
        }
        catch(Exception e)
        {
        }
        ChatHandler.clientsVector.add(this);
start();
}

public void run()
{
while(true)
{
    try{
    String str = dis.readLine();
    if(str!=null)
    {
    System.out.println(str);
    
    sendMessageToAll(str);
    }
}
catch(Exception e){

}
}
}
void sendMessageToAll(String msg)
{
// for(ChatHandler ch : clientsVector)
for(int i=0 ; i<clientsVector.size() ; i++)
{
    System.out.println(i);
clientsVector.get(i).ps.println(msg);
}
}



}