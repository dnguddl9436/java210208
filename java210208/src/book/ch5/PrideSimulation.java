package book.ch5;

public class PrideSimulation {

	public static void main(String[] args) {
		//private으로 했을 경우 인캡슐레이션이 적용되는 것이다.
		//생성자를 선언할 때  private으로 선언 했으므로 디폴트 생성자를
		//활용하고 싶다면 싱글톤 패턴으로 정의하여 사용해야 한다.
		//Pride myCar = new Pride();
		Pride herCar = new Pride(10);
		Pride himCar = new Pride(100, 4);
		himCar.wheelNum = 4;//4->14
		herCar.wheelNum = 14;
		Pride.wheelNum = 5;
		himCar.speed = 10;//10->50
		herCar.speed = 50;
		System.out.println("himCar.wheelNum : "+himCar.wheelNum);
		System.out.println("herCar.wheelNum : "+herCar.wheelNum);
		System.out.println("herCar.wheelNum : "+Pride.wheelNum);
		System.out.println("himCar.speed : "+himCar.speed);
		System.out.println("herCar.speed : "+herCar.speed);
	}

}
