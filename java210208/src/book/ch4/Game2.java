package book.ch4;

import java.util.Scanner;
import java.util.Random;

public class Game2 {
	int num, ans;
	Random r = new Random();
	Scanner sc = new Scanner(System.in);

	void run(Game2 g) {
		g.ans = r.nextInt(10);
		System.out.println("0~9사이의 숫자를 맞추는 게임입니다.");
		for (int i = 3; i > 0; i--) {
			System.out.print("숫자를 입력하세요(기회" + i + "번): ");
			g.num = sc.nextInt();
			if (g.num < g.ans)
				System.out.println("UP");
			else if (g.num > g.ans)
				System.out.println("DOWN");
			else {
				System.out.println("정답!");
				return;
			}
		}
		System.out.println("GAMEOVER... 정답은 " + g.ans + "입니다.");
	}

	public static void main(String[] args) {
		Game2 g = new Game2();
		g.run(g);
	}

}
