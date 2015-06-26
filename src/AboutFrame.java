import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class AboutFrame extends Dialog implements ActionListener,WindowListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button OkayBT;
	private MyCanvas c;
	public AboutFrame(Frame parent, String title, boolean modal){
		super(parent,title,modal);
		addWindowListener(this);
		OkayBT=new Button("Okay");
		c=new MyCanvas();
		setLayout(new BorderLayout());
		Panel p2=new Panel();
		p2.add(OkayBT);
		add("Center",c);
		add("South",p2);		
		OkayBT.addActionListener(this);
		this.setSize(300,200);
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		String arg=e.getActionCommand();
		if(e.getSource() instanceof Button){
			if("Okay".equals(arg)){
				this.setVisible(false);
			}
		}
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		setVisible(false);
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
class MyCanvas extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyCanvas(){
		repaint();
	}
	public void paint(Graphics g){
		Font f2=new Font("TimesRoman",Font.PLAIN,13);
		Font f=new Font("TimesRoman",Font.BOLD,20);		
		g.setFont(f);
		g.drawString("Chat App 1.0.1", 65, 50);
		g.setFont(f2);
		g.drawString("A Java based LAN Messenger", 50, 80);
		g.drawString("Copyrighted © 2014 by Titans Incorporation",5,100);
		g.drawString("Developed by Zubair",70,120);
	}
}
