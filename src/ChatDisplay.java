import java.awt.Font;
import java.awt.TextArea;


public class ChatDisplay{
	String Message,Name;
	TextArea ChatDisp;
	public ChatDisplay(String Message,String Name,TextArea ChatDisp){
		this.Message=Message;
		this.Name=Name;
		this.ChatDisp=ChatDisp;
		Font f=new Font("Helvetica",Font.BOLD,13);
		ChatDisp.setFont(f);
		ChatDisp.append(Name+" : \n");
		ChatDisp.append(Message+"\n\n");
	}
}
