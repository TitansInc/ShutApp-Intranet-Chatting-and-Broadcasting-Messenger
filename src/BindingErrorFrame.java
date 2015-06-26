import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class BindingErrorFrame extends Dialog implements ActionListener,WindowListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button OkayBT;
	private MyCanvas3 c;
	public BindingErrorFrame(Frame parent, String title, boolean modal,String Message){
		super(parent,title,modal);
		addWindowListener(this);
		OkayBT=new Button("Okay");
		c=new MyCanvas3(Message);
		setLayout(new BorderLayout());
		Panel p2=new Panel();
		p2.add(OkayBT);
		add("Center",c);
		add("South",p2);		
		OkayBT.addActionListener(this);
		this.setSize(280,100);
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		String arg=e.getActionCommand();
		if(e.getSource() instanceof Button){
			if("Okay".equals(arg)){
				System.exit(0);
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
class MyCanvas3 extends Canvas{
	/**
	 * 
	 */
	String Message;
	private static final long serialVersionUID = 1L;
	public MyCanvas3(String Message){
		this.Message=Message;
		repaint();
	}
	public void paint(Graphics g){
		g.drawString(Message, 25, 30);
	}
}
