package book.ch7;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGameView {
	boolean used[] = new boolean[10];
	int n = 3;
	int com[] = new int[n];
	String user = null;
	Random r = new Random();
	Scanner sc = new Scanner(System.in);

	public void initUsed(BaseBallGameView bg) {
		for (int i = 0; i < 10; i++)
			bg.used[i] = false;
	}

	public void makeCom(BaseBallGameView bg) {
		int cnt = 0;
		bg.initUsed(bg);
		do {
			bg.com[cnt] = r.nextInt(10);
			if (!bg.used[bg.com[cnt]])
				bg.used[bg.com[cnt++]] = true;
		} while (cnt < bg.n);
	}

	public void printBall(BaseBallGameView bg) {
		for (int i = 0; i < bg.n; i++)
			System.out.print(bg.com[i]);
	}

	public void run(BaseBallGameView bg) {
		int strike, ball;
		bg.makeCom(bg);
		do {
			strike = 0;
			ball = 0;
			System.out.print("세 자리 숫자를 입력하세요: ");
			bg.user = sc.nextLine();
			for (int i = 0; i < n; i++) {
				if (bg.com[i] == bg.user.charAt(i)-'0') {
					strike++;
				} else if (used[bg.user.charAt(i)-'0']) {
					ball++;
				}
			}
			System.out.println(strike+"S"+ball+"B");
		} while (strike != n);
		System.out.println("정답입니다!");
	}

	public static void main(String[] args) {
		BaseBallGameView bg = new BaseBallGameView();
		bg.run(bg);
	}

}
