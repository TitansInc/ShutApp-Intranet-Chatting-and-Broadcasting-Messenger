import java.awt.Frame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;


public class ServerScript extends Thread{
	String Ip,Name;
	Frame f;
	public ServerScript(String Ip, String Name,Frame f){
		this.Ip=Ip;
		this.f=f;
		this.Name=Name;
		start();
		}
	public  void run(){
		try{

			
			@SuppressWarnings("resource")
			ServerSocket server=new ServerSocket(1234);
			while(true){
			Socket connectToClient=server.accept();
			DataOutputStream out=new DataOutputStream(connectToClient.getOutputStream());
			out.writeUTF(Ip+" "+Name);
			DataInputStream In=new DataInputStream(connectToClient.getInputStream());
			String s=In.readUTF();
			if(!("".equals(s))){
				new ChatFrame(s,0);
			}
			}
		}catch(IOException e){
			BindingErrorFrame w=new BindingErrorFrame(f,"Binding Error",false,"Address Already In Use on Port 1234");
			w.setVisible(true);
			w.setLocation(400,250);
			}

		}
}