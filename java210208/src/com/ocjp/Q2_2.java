package com.ocjp;

import java.util.Scanner;

public class Q2_2 {
	int from, n, sum;
	Scanner sc = new Scanner(System.in);

	void input(Q2_2 q) {
		System.out.print("첫 항을 입력하세요: ");
		q.from = sc.nextInt();
		System.out.print("배수를 입력하세요: ");
		q.n = sc.nextInt();
	}

	void run(Q2_2 q) {
		q.sum = q.from;
		System.out.print("7번째까지의 수열: ");
		for (int i = 0; i < 7; i++) {
			q.sum *= q.n;
			System.out.print(q.sum + " ");
		}
	}

	public static void main(String[] args) {
		Q2_2 q = new Q2_2();
		q.input(q);
		q.run(q);
	}

}
