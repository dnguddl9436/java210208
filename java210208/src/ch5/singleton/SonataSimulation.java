package ch5.singleton;

public class SonataSimulation {

	public static void main(String[] args) {
		Sonata yourCar = Sonata.getInstance();
		Sonata meCar = Sonata.getInstance();
		Sonata gnomCar = Sonata.getInstance();
		System.out.println(yourCar);
		System.out.println(meCar);
		System.out.println(gnomCar);
	}

}
