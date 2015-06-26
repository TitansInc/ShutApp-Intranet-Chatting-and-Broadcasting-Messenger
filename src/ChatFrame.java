import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class ChatFrame extends MyFrameWithExitHandling implements ActionListener{
	/**
	 * 
	 */
	static Map<String, String> m1=new HashMap<String, String>();
	static Map<String,Socket> m2=new HashMap<String,Socket>();
	MenuBar mb=new MenuBar();
	private static final long serialVersionUID = 1L;
	Panel p1,p2,p3,p4,p5;
	static TextArea ChatDisp;
	TextArea MessBox;
	Button Send,Close;
	GridBagLayout gbLayout;
	GridBagConstraints gbConstraints, gbConstraints2;
	Label label,label2;
	Panel p6,p7,p8,p9,p10;
	public static List lst =new List(256,true);
	ChatDisplay update;
	String Ip;
	String Name;
	ClientScript Client;
	String SName,SIp;
	public ChatFrame(String NMessage,int h){
		int i=NMessage.indexOf("$");
		String Name=new String(NMessage.substring(0, i));
		String Mess=new String(NMessage.substring(i+1,NMessage.length()));
		new ChatDisplay(Mess,Name,ChatFrame.ChatDisp);
	}
	public ChatFrame(String Sstring){
		SIp=Sstring.substring(0,Sstring.indexOf(" ")+1);
		SName=Sstring.substring(Sstring.indexOf(" ")+1,Sstring.length());
		ChatFrame.m1.put(SName, SIp);

		
	}
	public ChatFrame(String Name,Socket s){
		m2.put(Name,s);
	}
	@SuppressWarnings("static-access")
	public ChatFrame(String Name, String Ip){	
		super("ChatBox");
		this.setMenuBar(mb);
		Menu FileMenu=new Menu("File",true);
		Menu EditMenu=new Menu("Edit",true);
		mb.add(FileMenu);
		mb.add(EditMenu);
		MenuItem About=new MenuItem("About");
		MenuItem Exit=new MenuItem("Exit");
		MenuItem Refresh=new MenuItem("Update List");
		MenuItem Clear=new MenuItem("Clear History");
		

		
		FileMenu.add(About);
		FileMenu.add(new MenuItem("-"));
		FileMenu.add(Exit);
		EditMenu.add(Refresh);
		EditMenu.add(new MenuItem("-"));
		EditMenu.add(Clear);
		
		About.addActionListener(this);
		Exit.addActionListener(this);
		Refresh.addActionListener(this);
		Clear.addActionListener(this);
		
		new ServerScript(Ip,Name,this);
		this.m1.put(Name, Ip);
		Client=new ClientScript(Ip,Name);
		this.Ip=Ip;
		this.Name=Name;
		Font f=new Font("Helvetica",Font.BOLD,12);
		Font f2=new Font("Helvetica",Font.PLAIN,13);
		this.setSize(600,450);
		this.setLocation(400,100);
		lst.setFont(f2);
		

		gbLayout=new GridBagLayout();
		gbConstraints=new GridBagConstraints();
		gbConstraints2=new GridBagConstraints();
		setLayout(gbLayout);		
		MessBox=new TextArea("",5,60,MessBox.SCROLLBARS_NONE);
		Send=new Button("Send");
		Close=new Button("Close");
		Color color=new Color(240,240,240);
		Color color2=new Color(220,220,220);
		this.setBackground(color);
		ChatDisp=new TextArea("",16,60,ChatDisp.SCROLLBARS_NONE);
		ChatDisp.setEditable(false);
		ChatDisp.setBackground(Color.WHITE);
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		p4=new Panel();
		p5=new Panel();
		p6=new Panel();
		p7=new Panel();
		p8=new Panel();
		p9=new Panel();
		p10=new Panel();
		
		
		label=new Label("         Online Friends List          ");
		label.setBackground(new Color(220,220,220));

		label2=new Label("Chat History          ");
		label2.setBackground(new Color(220,220,220));
		label2.setFont(f);
		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout(10,10));
		p3.setLayout(new BorderLayout());
		p4.setLayout(new BorderLayout(10,10));
		p5.setLayout(new BorderLayout());
		p6.setLayout(new GridLayout(1,1));
		p9.setLayout(new GridLayout(1,2,5,5));
		
		p9.add(Send);
		p9.add(Close);
		p6.add(label);
		p6.setBackground(color2);
		p6.setFont(f);
		p1.add("North",p6);
		
		p7.setBackground(color);
		p7.setLayout(new FlowLayout());
		p8.setLayout(new GridLayout(1,1));
		p7.add(new Label(""));
		p1.add("Center",p8);
		p1.add("South",p7);
		p8.add(lst);
		
		
		p3.add("North",label2);
		p3.add(ChatDisp);
		p5.add("East",p9);
		p4.add("Center",MessBox);		
		p4.add("South",p5);
		p2.add("Center",p3);
		p2.add("South",p4);
		
		gbConstraints.gridx=0;
		gbConstraints.gridy=0;
		gbConstraints.gridwidth=1;
		gbConstraints.gridheight=3;
		gbConstraints.weightx=0;
		gbConstraints.weighty=0;
		gbConstraints.fill=gbConstraints.BOTH;
		gbConstraints.insets=new Insets(10,10,0,10);

		gbLayout.setConstraints(p1, gbConstraints);
		for(int k=0;k<100000000;k++);
		gbConstraints2.gridx=1;
		gbConstraints2.gridy=0;
		gbConstraints2.gridwidth=2;
		gbConstraints2.gridheight=3;
		gbConstraints2.weightx=20;
		gbConstraints2.weighty=20;
		gbConstraints2.fill=gbConstraints2.BOTH;
		gbConstraints2.insets=new Insets(10,0,5,10);
		gbLayout.setConstraints(p2, gbConstraints2);
		p1.setBackground(Color.WHITE);
		add(p1);
		add(p2);
		Close.addActionListener(this);
		Send.addActionListener(this);	
		ListUpdate();
	}
	public void actionPerformed(ActionEvent e) {
		String Message;
		String arg=e.getActionCommand();
		if(e.getSource() instanceof Button){
			if("Close".equals(arg)){
				System.exit(0);
			}
			else if("Send".equals(arg)){
				if("".equals(MessBox.getText())){
					Warning w=new Warning(this,"Message Warning",false,"You Better Enter Some Message");
					w.setVisible(true);
					w.setLocation(400,250);
				}
				else{
					@SuppressWarnings("unused")
					String[] items= lst.getSelectedItems();
					Message=MessBox.getText();
					MessBox.setText("");
					update=new ChatDisplay(Message,Name,ChatFrame.ChatDisp);
					new ClientScript(lst.getSelectedItems(),Message,Ip,Name,ChatFrame.m1);
					ChatFrame.m1.clear();
					m1.put(Name, Ip);
					new ClientScript(Ip,Name);
					for(int i=0;i<100000000;i++);
					ListUpdate();
					}
			}
		}
		if(e.getSource() instanceof MenuItem){
			if("Exit".equals(arg)){
				System.exit(0);
			}
			else if("About".equals(arg)){
				AboutFrame AboutF=new AboutFrame(this,"About ChatApp",false);
				AboutF.setVisible(true);
				AboutF.setLocation(450,100);
			}
			else if("Update List".equals(arg)){
				ChatFrame.m1.clear();
				m1.put(Name, Ip);
				new ClientScript(Ip,Name);
				for(int i=0;i<10000000;i++);
				ListUpdate();

			}
			else if("Clear History".equals(arg)){
					ChatDisp.setText("");
			}
			
		}
			
		
	}

	@SuppressWarnings("deprecation")
	public void ListUpdate(){
		String[] selectedItems=lst.getSelectedItems();
		lst.removeAll();
		Iterator<String> itr=m1.keySet().iterator();
		int i=0;
		while(itr.hasNext()){
			String z=(String) itr.next();
			ChatFrame.lst.addItem(z);
			for(int k=0;k<selectedItems.length;k++){
				if(z.equals(selectedItems[k])){
					lst.select(i);
					break;
				}
			}
			i++;
			}
			
	}
}
