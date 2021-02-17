package com.ocjp;

public class Pass {
/* 실행순서는....7-8(x에 5가 저장됨)-9(주번생김)-10(메소드 호출됨-파라미터로 5가 복사됨)-15(후위연산자라서 5가 출력됨)
 * -16(15에서 파라미터로 5가 먼저 출력됨)-16에서 증감연산자가 적용된 6이 출력되는 것임.
 */
	public static void main(String[] args) {
		int x = 5; //이 x와
		Pass p = new Pass();
		p.doStuff(x);//값에 의한 호출이다.
		System.out.print(" main x = " + x);
	}//end of main

	void doStuff(int x) {//여기서 x는 서로 다른 x이다.
		System.out.print(" doStuff x = " + x++);
		System.out.print(" doStuff x = " + x);
	}//end of doStuff
}
