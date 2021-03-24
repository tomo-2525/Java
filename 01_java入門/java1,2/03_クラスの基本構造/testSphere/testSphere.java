class Sphere {

	float radius;
	float volume;

	Sphere() {// constructor
		this.radius = 3;
	}

	double CalVolume(float radius) {
		return (double) (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	}

	float heightContactPoint(Sphere sphere) {
		return 2 * radius * sphere.radius / (radius + sphere.radius);
	}

}

class testSphere {
	public static void main(String[] args) {

		Sphere sphere1 = new Sphere();
		Sphere sphere2 = new Sphere();
		Sphere sphere3 = new Sphere();

		sphere1.radius = 4.5f;
		sphere2.radius = 4.5f;
		sphere3.radius = 2.5f;

		System.out.println("Volume  height is " + sphere1.heightContactPoint(sphere1));
		System.out.println("Volume  height is " + sphere1.heightContactPoint(sphere2));
		System.out.println("Volume  height is " + sphere1.heightContactPoint(sphere3));

		System.out.println("Volume value is " + sphere1.CalVolume(sphere1.radius));
		System.out.println("Volume value is " + sphere2.CalVolume(sphere2.radius));
		System.out.println("Volume value is " + sphere3.CalVolume(sphere3.radius));
	}
}
