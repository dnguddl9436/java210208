package kosmo.exam210524;

public class Exam2 {

	public static void main(String[] args) {
		int i = 1;
		// while문 버전
		while (i < 101) {
			if (i % 5 == 0)
				System.out.print("fizz");
			if (i % 7 == 0)
				System.out.print("buzz");
			if (!(i % 5 == 0 || i % 7 == 0))
				System.out.print(i);
			System.out.print(" ");
			i++;
		}
		System.out.println();
		// for문 버전
		for (i = 1; i < 101; i++) {
			if (i % 5 == 0)
				System.out.print("fizz");
			if (i % 7 == 0)
				System.out.print("buzz");
			if (!(i % 5 == 0 || i % 7 == 0))
				System.out.print(i);
			System.out.print(" ");
		}
	}
}
