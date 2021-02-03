package event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionEventTest extends JFrame implements ActionListener{
	JPanel pane = new JPanel();
		JTextField tf = new JTextField(10);
		JButton btn1 = new JButton("구구단");
		JButton btn2 = new JButton("구구단 (전체)");
	
	JTextArea ta = new JTextArea("a\nb\nc");
	JScrollPane sp = new JScrollPane(ta);
	public ActionEventTest() {
		pane.add(tf);
		pane.add(btn1);
		pane.add(btn2);
		//      "North"
		add(BorderLayout.NORTH, pane);
		add(BorderLayout.CENTER, sp);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// 1. interface상속
		// 2. 추상메소드 오버라이딩
		// 3. 컴퍼넌트 이벤트 등록
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		tf.addActionListener(this);
	}
	//오버라이딩
	public void actionPerformed(ActionEvent ae) {//JButton, JTextField
		
		//이벤트가 발생한 컴퍼넌트 알아내기
		String event = ae.getActionCommand();//버튼의 라벨얻어옴
		System.out.println(event);
		//System.out.println(event);
		if(event.equals("구구단")) {
			String gugudan="";
			int dan = Integer.parseInt(tf.getText());
			for(int i=2; i<=9; i++) {
				gugudan+= dan + " * " + i + " = "+ dan*i+"\n";
			}
			//append() : 추가
			//setText() : 기존 내용지우고 추가
			//insertText() : 중간에 추가
			//ta.insert(gugudan,1);
			ta.setText(gugudan);
		}else if(event.equals("구구단 (전체)")) {
			String gugudan = "";
			for(int dan=2; dan<=9; dan++) {
				for(int i=2; i<=9; i++) {
					gugudan += dan+" * " + i + " = " + dan*i+"\n";
				}
			}
			ta.setText(gugudan);
		}	
	}
	public static void main(String[] args) {		
		new ActionEventTest();
	}
}





