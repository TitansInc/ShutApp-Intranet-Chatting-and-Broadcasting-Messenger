import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class MyFrameWithExitHandling extends Frame implements WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrameWithExitHandling(){
		super();
		addWindowListener(this);
	}
	public MyFrameWithExitHandling(String s){
		super(s);
		addWindowListener(this);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		dispose();
		System.exit(0);	
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
