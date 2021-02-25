package book.ch4;

public class FizzBuzzGame {

	public static void main(String[] args) {
		for (int i = 1; i < 101; i++) {
			switch (i % 35) {
			case 0:
				System.out.println("fizzbuzz");
				break;
			default:
				switch (i % 5) {
				case 0:
					System.out.println("fizz");
					break;
				default:
					switch (i % 7) {
					case 0:
						System.out.println("buzz");
						break;
					default:
						System.out.println(i);
					}
				}
			}
		}
	}
}
