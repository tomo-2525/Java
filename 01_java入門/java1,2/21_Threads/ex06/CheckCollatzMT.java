import java.math.BigInteger;
import java.util.Date;


public class CheckCollatzMT {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage:");
      System.out.println("java CheckCollatzMT n num_threads");
      System.out.println("where positive integers i: 1<= i <= n will be checked");
      System.out.println("and num_threads is the number of threads to use");
      System.exit(1);
    }


    BigInteger maxN = new BigInteger(args[0]);
    int NumberOfThread = Integer.parseInt(args[1]);
    int range = maxN.divide(new BigInteger(String.valueOf(NumberOfThread))).intValue();
    CollatzRunnable[] runnable = new CollatzRunnable[NumberOfThread];
    Thread [] thread = new Thread[NumberOfThread];

    for(int i = 0; i<NumberOfThread; i++){
      runnable[i] = new CollatzRunnable(new BigInteger(String.valueOf(i*range)), new BigInteger(String.valueOf((range)*(i+1))));
    }

    long start_time = new Date().getTime();

    int j = 0;
    for(CollatzRunnable r : runnable){
      thread[j] = new Thread(r);
      thread[j].start();
      j++;
    }


    try {
      for (int i = 0; i < NumberOfThread; i++) {
        thread[i].join();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }


    boolean bool = true;
    for (int i = 0; i < NumberOfThread; i++) {
      if (!runnable[i].bool) {

        bool = false;
      }
    }

    long end_time = new Date().getTime();
    System.out.println("Ellapsed time: " + (end_time - start_time) + "ms");
    if(bool){
      System.out.println("success");
    }else{
      System.out.println("error");
    }

  }
}
class CollatzRunnable implements Runnable{
  BigInteger min;
  BigInteger max;
  boolean bool = true;

  CollatzRunnable(BigInteger min, BigInteger max){
    this.min = min;
    this.max = max;
  }
  public void run() {
    BigInteger n = this.max;
    while (n.compareTo(this.min) > 0) {
      boolean res = Collatz.getResult(n);
      if (!res) {
        this.bool = false;
        break;
      }
      n = n.subtract(BigInteger.ONE);
    }

  }

}
