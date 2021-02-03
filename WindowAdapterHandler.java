package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowAdapterHandler extends JFrame{
    JFrame frm ;
	public WindowAdapterHandler() {
		frm = this;
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		// 추상메소드가 오버라이딩 되어있는  Adapter클래스를 재 오버라이딩한다.
		// 익명의 내부 클래스
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int status = JOptionPane.showConfirmDialog(frm, "정말 종료하시겠습니까?");
				if(status==JOptionPane.OK_OPTION) {
					dispose();
					System.exit(0);
				}
			}
		});
	}

	public static void main(String[] args) {
		new WindowAdapterHandler();
	}
}
