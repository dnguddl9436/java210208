package com.design.zipcode;

import javax.swing.JFrame;

public class ZipCodeSearch extends JFrame{
	//선언부
	
	//생성자
	public ZipCodeSearch() {}//파라미터가 없는 생성자를 디폴트 생성자라고 한다.
	//화면 처리부
	public void initDisplay() {
		this.setTitle("우편번호 검색기");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		ZipCodeSearch zcs = new ZipCodeSearch();
		//zcs.initDisplay();
	}

}
