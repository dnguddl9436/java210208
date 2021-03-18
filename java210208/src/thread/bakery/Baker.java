package thread.bakery;

public class Baker extends Thread{
	BakerStack bs = null;
	public Baker(BakerStack bs) {
		this.bs = bs;
	}
	@Override
	public void run() {
		String bread = null;
		bread = getBread();
		bs.push(bread);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("누구?");
		}
	}
	public String getBread() {
		String bread = null;
		return bread;
	}
}
