package book.ch4;

public class Googoo {
	void run1() {
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
			System.out.println();
		}
	}
	void run2() {
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Googoo g = new Googoo();
		g.run1();
		g.run2();
	}

}
