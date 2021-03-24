abstract class Animal {
    private static int count; // ban remoneing static keyword
    public static void increment() { count++; }
    public static int getCount() { return count; }
    abstract void noise();
}
class Dog extends Animal {
    private static int count;
    
    public Dog() {};
    
    public static void increment() { count++; }
    public static int getCount() { return count; }
    public void noise() {
	
	System.out.println("Woof");
	increment();
    }
}
class Cat extends Animal {
    private static int count;
    
    public Cat() {};
    
    public static void increment() { count++; }
    public static int getCount() { return count; }
    public void noise() {
	System.out.println("Meow");
	increment();
    }
}
public class Counter{
    public static void main(String[] args) {
	Animal[] a = {new Dog(), new Cat(), new Cat(), new Dog(), new Dog()};
	for (int i = 0; i < a.length; i++)
	    a[i].noise();
	System.out.println(Dog.getCount() + " woofs and " + Cat.getCount() + " meow");
    }
} 
