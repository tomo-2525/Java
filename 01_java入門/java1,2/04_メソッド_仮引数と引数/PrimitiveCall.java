public class PrimitiveCall {

  public static void myMethod(int k) {
    System.out.println("myMethod: k= " + k);
    k = 100;
    System.out.println("myMethod: k= " + k);
  }

  public static void main(String argv[]) {
    int k = 5;
    System.out.println("main: k= " + k);
    myMethod(k);
    System.out.println("main: k= " + k);
  }
}