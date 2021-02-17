package book.ch4;

import java.util.Scanner;
import java.util.Random;

public class RandomGame1 {

	public static void main(String[] args) {
		//난수 발생을 지원하는 클래스 추가하기 - 인스턴스화 하기
		Random r = new Random();
		//그 클래스가 제공하는 메소드를 호출하여 채번하기
		int ans = r.nextInt(10);
		//사용자로부터 입력한 값 받아오기
		Scanner sc = new Scanner(System.in);
		//사용자가 입력한 값 담기 - 선언하기, 초기화
		
		//0부터 9중에서 골라봐~~~~?
		
		//기회를 3번까지는 준다. - 1번, 2번, 3번, 반복법
		int num;
		System.out.println("0~9사이의 숫자를 맞추는 게임입니다.");
		for (int i = 3; i > 0; i--) {
			System.out.print("숫자를 입력하세요(기회" + i + "번): ");
			num = sc.nextInt();
			if (num < ans)
				System.out.println("UP");
			else if (num > ans)
				System.out.println("DOWN");
			else {
				System.out.println("정답!");
				return;
			}
		}
		System.out.println("GAMEOVER... 정답은 " + ans + "입니다.");
	}

}
