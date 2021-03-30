package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_4 extends JFrame{
	JButton jbtn = null;
	boolean isView = false;
	public A_4() {
		jbtn = new JButton("전송2");
		initDisplay();
	}
	public A_4(boolean isView) {
		this.isView = isView;
		initDisplay();
		//위치가 중요하다.
		jbtn = new JButton("전송3");
	}
	public void initDisplay() {
		this.add("Center",jbtn);
		this.setSize(500, 300);//상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A_4(true);
	}

}
