package com.ocjp;

import java.util.Scanner;

public class Q1_2 {
	int from, to, cnt;
	Scanner sc = new Scanner(System.in);

	void input(Q1_2 q) {
		System.out.print("첫 번째 정수 입력: ");
		q.from = sc.nextInt();
		System.out.print("두 번째 정수 입력: ");
		q.to = sc.nextInt();
	}

	void run(Q1_2 q) {
		for (int i = q.from; i <= q.to; i++)
			if (i % 3 == 0)
				q.cnt++;
		System.out.println(q.from + "~" + q.to + "사이에 있는 3의 배수는 " + q.cnt + "개 입니다.");
	}

	public static void main(String[] args) {
		Q1_2 q = new Q1_2();
		q.input(q);
		q.run(q);
	}

}
