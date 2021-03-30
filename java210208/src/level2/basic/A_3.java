package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_3 extends JFrame{
	//JButton jbtn = null;
	JButton jbtn = new JButton("전송");
	boolean isView = false;
	public A_3() {
		initDisplay();
	}
	public A_3(boolean isView) {
		this.isView = isView;
		initDisplay();
	}
	public void initDisplay() {
		this.add("Center",jbtn);
		this.setSize(500, 300);//상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A_3(true);
	}

}
