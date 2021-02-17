package com.ocjp;

public class ParamTest {

	public static void main(String[] args) {
		ParamTest pt = new ParamTest();
		Param p = new Param();
		p.ival = 100;
		System.out.println(p.ival);
		pt.effectParam(p);
	}
	public void effectParam(Param p) {
		p.ival = 500;
		System.out.println(p.ival);
	}
	
}
