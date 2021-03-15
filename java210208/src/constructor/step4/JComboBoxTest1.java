package constructor.step4;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboBoxTest1 extends JFrame {
	//선언부
	JPanel		jp_north	= null;
	JComboBox	jcb_top		= null;
	JComboBox	jcb_mid		= null;
	JComboBox	jcb_bottom	= null;
	String		top_item[]		= {"전체","가전","컴퓨터","모바일"};
	String		mid_item0[]		= {"전체","주방가전","생활가전","계절가전"};
	String		mid_item1[]		= {"전체","노트북","브랜드PC","모니터"};
	String		mid_item2[]		= {"전체","휴대폰","태블릿","스마트워치"};
	String		bottom_item[]	= {"전체","가전","모바일"};
	//생성자
	public JComboBoxTest1() {
		jp_north	= new JPanel();
		//super("대중소분류 실습");
		jcb_top 	= new JComboBox(top_item);
		jcb_mid		= new JComboBox();
		jcb_bottom	= new JComboBox();
		initDisplay();
	}
	//화면 처리부
	public void initDisplay() {
		jp_north.setBackground(Color.orange);
		jp_north.add(jcb_top);
		jp_north.add(jcb_mid);
		jp_north.add(jcb_bottom);
		this.add("North",jp_north);
		this.setTitle("대중소분류 실습");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	//메인메소드 선언
	public static void main(String[] args) {
		new JComboBoxTest1();//생성자를 경유하고 생성자에서 화면처리 메소드 호출해보기 - 시점문제에 대해 같이 고민.
	}

}
