package com.ocjp;

import java.util.Scanner;

public class Q2_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 항을 입력하세요: ");
		int from = sc.nextInt();
		System.out.print("배수를 입력하세요: ");
		int n = sc.nextInt();
		int sum = from;
		System.out.print("7번째까지의 수열: ");
		for (int i = 0; i < 7; i++) {
			sum *= n;
			System.out.print(sum + " ");
		}
	}

}
