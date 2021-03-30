package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_7 extends JFrame{
	JButton jbtn = null;
	boolean isView = false;
	B b = null;//타입만 결정 되었으므로 시점에 따라 NullPointerException발지 해야 함.
	C c = new C();//A가 컴파일 될때 같이 메모리에 상주
	//B b = new B(this);
	
	public A_7() {
		jbtn = new JButton("전송2");
		initDisplay();
	}
	public A_7(boolean isView) {
		this.isView = isView;
//		jbtn = new JButton("전송3");
		jbtn = new JButton();
//		jbtn.setText("전송4");
		initDisplay();
		jbtn.setText("전송5");//동기화 처리가 되고 있어서 괜찮아
		//위치가 중요하다.
	}
	public void initDisplay() {
		b = new B(this);//게으른 인스턴스화
		jbtn.addActionListener(b);
		//jbtn.addActionListener(b);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add("Center",jbtn);
		this.setSize(500, 300);//상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A_7(true);
	}

}
