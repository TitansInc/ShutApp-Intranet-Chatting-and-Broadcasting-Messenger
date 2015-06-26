
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StartupFrame extends MyFrameWithExitHandling implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button EnterBT=new Button("Enter Chat");
	private TextField NameF=new TextField(20);
	private TextField IpF=new TextField(20);
	private String Name;
	private String IP;
	ChatFrame ChatF;
	AboutFrame AboutF;
	MenuBar mb=new MenuBar();
	MenuItem AboutMenu, ExitMenu;
	Menu fileMenu=new Menu("File",true);
	private Label label,iplabel;
	ChatFrame n;
	public StartupFrame(){
		this.setBackground(new Color(250,250,250));
		Font f=new Font("Helvetica",Font.PLAIN,14);
		fileMenu.add(AboutMenu=new MenuItem("About"));
		fileMenu.addSeparator();
		fileMenu.add(ExitMenu=new MenuItem("Exit"));
		mb.add(fileMenu);
		setMenuBar(mb);
		AboutMenu.addActionListener(this);
		ExitMenu.addActionListener(this);
		
		setTitle("Shut App");
		setLayout(new GridLayout(6,1));
		Panel p1=new Panel();
		p1.setLayout(new BorderLayout());
		Panel p2=new Panel();
		Panel p3=new Panel();
		Panel p4=new Panel();
		Panel p5=new Panel();
		Panel p6=new Panel();
		Panel p7=new Panel();
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p4.setLayout(new FlowLayout());
		p5.setLayout(new FlowLayout());
		p6.setLayout(new BorderLayout());
		p7.setLayout(new GridLayout(8,1));
		p2.add(label=new Label("Enter Name "));
		p2.add(NameF);
		p5.add(iplabel=new Label("Enter Ip Add"));
		p5.add(IpF);
		label.setFont(f);
		iplabel.setFont(f);
		p3.add(EnterBT);

		
		p1.add("North",p2);
		p1.add("Center",p5);
		p1.add("South",p3);
		for(int h=0;h<=5;h++){
			p7.add(new Label(""));

		}
		p7.add(new Label("         Designed and Developed by Zubair       "));
		p7.add(new Label("Copyrighted © 2014 by Titans Incorporation       "));
		p6.add("South",p7);
		add(p4);
		add(p1);
		add(p6);
		EnterBT.addActionListener(this);
		this.setLocation(400, 30);
	}
	public static void main(String args[]){
		Frame f=new StartupFrame();
		f.setSize(290,720);
		f.setVisible(true);
		f.setResizable(false);
		
	}
	public void actionPerformed(ActionEvent e) {
			String arg=e.getActionCommand();
			if(e.getSource() instanceof Button){
				if("Enter Chat".equals(arg)){
					Name=NameF.getText();
					IP=IpF.getText();
					if("".equals(Name)){
						Warning w=new Warning(this,"Waring",false,"    You Better Enter Your Name");
						w.setVisible(true);
						w.setLocation(400,200);
						}
					else if("".equals(IP)){
						Warning w=new Warning(this,"Waring",false,"You Better Enter Your IP Address");
						w.setVisible(true);
						w.setLocation(400,200);
					}
					else{
						ChatF=new ChatFrame(Name,IP);
						ChatF.setVisible(true);
						this.setVisible(false);	
					}	
				}
			}
			if(e.getSource() instanceof MenuItem){
				if("Exit".equals(arg)){
					System.exit(0);}
				else if("About".equals((String)arg)){
					AboutF=new AboutFrame(this,"About ShutApp",false);
					AboutF.setVisible(true);
					AboutF.setLocation(450,100);
				}
					
			}
	}
}
