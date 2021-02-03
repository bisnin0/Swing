package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class WindowEventHandler2 extends WindowAdapter{
	WindowEventTest2 w;
	public WindowEventHandler2() {}
	public WindowEventHandler2(WindowEventTest2 w) {
		this.w = w;
	}
	//재오버라이딩
	public void windowClosing(WindowEvent we) {		
		int status = JOptionPane.showConfirmDialog(w, "종료할까요?");
		if(status==JOptionPane.OK_OPTION) {
			w.dispose();
			System.exit(0);
		}
	}
}
