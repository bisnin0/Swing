package event;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MouseEventTest extends JFrame{
	MyCanvas mc = new MyCanvas();
	MyAdapter ma = new MyAdapter();
	int startX, startY;
	int lastX, lastY;
	int btn=0;
	public MouseEventTest() {
		add(mc);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		mc.addMouseListener(ma);
		mc.addMouseMotionListener(ma);//////
	}
	class MyAdapter extends MouseAdapter{
		//마우스를 누른 상태일때
		public void mousePressed(MouseEvent me) {
			// me에는 x, y좌표, 마우스버튼 종류
			btn = me.getButton();// 버튼 종류 왼쪽:1, 가운데:2, 오른쪽:3
			if(btn==MouseEvent.BUTTON1) {
				startX = me.getX(); //마우스가 클릭된곳의 X좌표
				startY = me.getY();
			}
		}
		//마우스에서 손을 놓았을때
		public void mouseReleased(MouseEvent me) {
//			if(me.getButton() == MouseEvent.BUTTON1) {
//				lastX = me.getX();
//				lastY = me.getX();
//				mc.repaint();//그림이 그려져야 한다.
//			}
			btn=0;
		}
		public void mouseDragged(MouseEvent me) {
			
			lastX = me.getX();
			lastY = me.getY();
			
			if(btn == MouseEvent.BUTTON1) {
				mc.repaint();
			}
			startX = lastX ;
			startY = lastY ;
		}
	}
	class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			System.out.println(startX+","+startY+", "+lastX+","+lastY);
			g.drawLine(startX, startY, lastX, lastY);
		}
		public void update(Graphics g) {
			paint(g);
		}
	}
	public static void main(String[] args) {
		new MouseEventTest();
	}
}
