import java.net.*;
import java.io.*;
import java.util.*;

public class ClientScript {


	public ClientScript(String Ip,String Name){
		int Index=Ip.lastIndexOf(".");
		String Ip1=Ip.substring(0,Index+1);
		String Ip2;
		for(int i=0;i<256;i++){
			Ip2=Ip1+i;
			new ClientThreadHandler(Ip2);
		}
		
		
	}
	public ClientScript(String[] Iplist,String Message,String Ip,String Name,Map<String, String> m2){
		for(int i=0;i<Iplist.length;i++){
			if(!(Ip.equals(Iplist[i]))){
				new ClientSenderThreadHandler(m2.get(Iplist[i]).trim(),Name,Message);
			}
		}
		
	}
}
class ClientThreadHandler extends Thread implements Runnable{
	String Ip;
	public ClientThreadHandler(String Ip){
		this.Ip=Ip;
		start();
	}
	public void run(){
		
		String Sstring;
		
		try {
			
			Socket connectToServer=new Socket(Ip,1234);
			new ChatFrame(Ip,connectToServer);
			InputStream inFromServer=connectToServer.getInputStream();
			DataInputStream in=new DataInputStream(inFromServer);
			Sstring=in.readUTF();
			new ChatFrame(Sstring);
			OutputStream outToServer=connectToServer.getOutputStream();
			DataOutputStream out=new DataOutputStream(outToServer);
			out.writeUTF("");
			connectToServer.close();
		}catch(IllegalThreadStateException e){
			System.out.println("Illegal Thread State Exception");
		}catch(IllegalStateException e){
			System.out.println(" Illegal State Exception");
		}
		catch (UnknownHostException e) {
			System.out.println("Unknown Host Exception");
		} catch (IOException e) {		
			//Do Nothing//
		} 
	}
}
class ClientSenderThreadHandler extends Thread{
	String Ip;
	String Message;
	String Name;
	public ClientSenderThreadHandler(String Ip,String Name,String Message){
		this.Ip=Ip;
		this.Message=Message;
		this.Name=Name;
		start();
	}
	public void run(){
		@SuppressWarnings("unused")
		String Sstring; 
		try {				
			Socket connectToServer=new Socket(Ip,1234);
			
			InputStream inFromServer=connectToServer.getInputStream();
			DataInputStream in=new DataInputStream(inFromServer);
			Sstring=in.readUTF();
			OutputStream outToServer=connectToServer.getOutputStream();
			DataOutputStream out=new DataOutputStream(outToServer);
			
			out.writeUTF(Name+"$"+Message);
			connectToServer.close();
		}catch(IllegalThreadStateException e){
			System.out.println("Illegal Thread State Exception");
		}catch(IllegalStateException e){
			System.out.println(" Illegal State Exception");
		}
		catch (UnknownHostException e) {
		e.printStackTrace();
		} catch (IOException e) {		
			//Do Nothing//
		} 
	}
}