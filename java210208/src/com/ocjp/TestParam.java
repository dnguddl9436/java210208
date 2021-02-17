package com.ocjp;
class Param {
	int ival;//전변은 초기화를 생략할 수 있음. 그래도 0임.
}
public class TestParam {
	void effectParam(Param p) {
		p = new Param();//insert here일때는 얼마가 출력되는 것일까요?
		p.ival = 500;
		System.out.println("sub ival="+p.ival);
	}
	public static void main(String[] args) {
		//클래스는 반드시 대문자
		TestParam tp = new TestParam();
		Param p = new Param();
		p.ival = 100;
		tp.effectParam(p);
		System.out.println("main ival="+p.ival);
	}

}
