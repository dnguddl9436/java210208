package com.ocjp;
/*
 * ++i는 i = i + 1; 과 같다.
 * --i는 i = i - 1; 과 같다.
 * i++는 후위 연산자이므로 먼저 비교하고 나중에 1을 증가시킴
 * ++i 전위 연산자이다.
 * 
 */
public class Exam1 {

	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		if ((++i > j--) & (++i > j)) {
			// 실행되는가?
			System.out.println(1);
		} else {
			// 실행되나?
			System.out.println(2);
		}
		// 변수 초기화가 있을 때와 없을 때 차이가 있습니까?
		i = 1;
		j = 2;

		if ((++i > j--) && (++i > j)) {
			System.out.println(3);

		} else {
			System.out.println(4);

		}
	}

}
