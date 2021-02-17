package com.ocjp;

import java.util.Scanner;

public class Q1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 입력: ");
		int from = sc.nextInt();
		System.out.print("두 번째 정수 입력: ");
		int to = sc.nextInt();
		int cnt = 0;
		for (int i = from; i <= to; i++)
			if (i % 3 == 0)
				cnt++;
		System.out.println(from + "~" + to + "사이에 있는 3의 배수는 " + cnt + "개 입니다.");
	}

}
