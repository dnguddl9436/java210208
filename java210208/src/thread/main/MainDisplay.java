package thread.main;

import javax.swing.JFrame;

public class MainDisplay extends Thread {
	JFrame jf = null;
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf = new JFrame();
		jf.setSize(500, 300);
		jf.setVisible(true);
	}
	public void run() {
		System.out.println("run 호출 성공");
	}
	public static void main(String[] args) {
		MainDisplay md = new MainDisplay();
		md.initDisplay();
		md.run();
	}
}
