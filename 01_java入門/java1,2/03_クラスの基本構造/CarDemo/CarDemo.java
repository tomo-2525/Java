class Car {
	int horsePower;
	int speed;
	int fuelConsumption;
	int gasTank;
	int travelledtime;

	Car() {// constructor
		this.horsePower = 100;
		this.speed = 0;
		this.fuelConsumption = 22;
		this.gasTank = 45;
		this.travelledtime = 15;
	}

	void speedUp(int increment) {
		speed = speed + increment;
	}

	void applyBrakes(int decrement) {
		speed = speed - decrement;
	}

	void travelledTimeUp(int increment) {
		travelledtime = travelledtime + increment;
	}

	void printStateTank() {
		int distance = speed * travelledtime;
		int usedfuel = distance / fuelConsumption;

		System.out.println(gasTank - usedfuel);
	}

}

class CarDemo {
	public static void main(String[] args) {

		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();

		car1.speedUp(3);
		car2.speedUp(4);
		car3.speedUp(5);

		car1.travelledTimeUp(2);
		car2.travelledTimeUp(3);
		car3.travelledTimeUp(1);

		car1.printStateTank();
		car2.printStateTank();
		car3.printStateTank();

	}
}
