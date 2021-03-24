import java.math.BigInteger;
import java.util.Date;

public class CheckCollatz {

  // Check the conjecture for 1 <= i <= n
  public static boolean check(BigInteger n) {
    
    while( n.compareTo(BigInteger.ZERO) > 0 ){
      boolean res = Collatz.getResult(n); 

      if (!res){
        return false;
      }
      n = n.subtract(BigInteger.ONE); // n--
    }
    return true;
  }


  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage:");
      System.out.println("java CheckCollatz n");
      System.out.println("will check the Collatz conjecture for");
      System.out.println("every 1 <= i <= n");
      System.exit(1);
    }

    long start_time = new Date().getTime();
    boolean v = CheckCollatz.check(new BigInteger(args[0]));
    long end_time = new Date().getTime();
    System.out.println("Ellapsed time: " + (end_time-start_time) + "ms");

    if (v) {
      System.out.println("The conjecture seems valid up to n="+args[0]);
    } else {
      System.out.println("The conjecture is not valid");
    }
  }
}
