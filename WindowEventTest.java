package event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class WindowEventTest extends JFrame implements WindowListener{
	JTextArea ta = new JTextArea();
	public WindowEventTest() {
		add(ta);		
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//이벤트등록
		addWindowListener(this);
	}
	//오버라이딩
	public void windowActivated(WindowEvent we) {
		System.out.println("Activated");
	}
	public void windowClosed(WindowEvent we) {}
	public void windowClosing(WindowEvent we) {
		//질문
		int status = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?");
		if(status == JOptionPane.OK_OPTION) {
			dispose();
			System.exit(0);
		}
	}
	public void windowDeactivated(WindowEvent we) {
		System.out.println("Deactivated");
	}
	public void windowDeiconified(WindowEvent we) {
		System.out.println("Deiconified");
	}
	public void windowIconified(WindowEvent we) {
		System.out.println("Iconified");
	}
	public void windowOpened(WindowEvent e) {
		System.out.println("Opened");
	}	
	public static void main(String[] args) {
		new WindowEventTest();
	}
}







