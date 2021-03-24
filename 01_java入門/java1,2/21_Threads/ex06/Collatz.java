import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class Collatz {


  private final static BigInteger TWO = new BigInteger("2");
  private final static BigInteger THREE = new BigInteger("3");


  public static Result check(BigInteger n) {
    HashSet<BigInteger> visited = new HashSet<BigInteger>();
    ArrayList<BigInteger> sequence = new ArrayList<BigInteger>();
    return check(n, visited, sequence);
  }

  public static Result check(BigInteger n, HashSet<BigInteger> visited , ArrayList<BigInteger> sequence) {
    if(n.equals(java.math.BigInteger.ONE)){
      sequence.add(java.math.BigInteger.ONE);
      return new Result(sequence, true);
    }

    if (visited.contains(n)) {
      return new Result(sequence, false);
    }

    visited.add(n);
    sequence.add(n);

    n = (n.mod(TWO).equals(java.math.BigInteger.ZERO)) ? n.divide(TWO) : n.multiply(THREE).add(java.math.BigInteger.ONE);
    return check(n, visited, sequence);
  }


  public static void main(String[] args) {
      //System.out.println(args[0]);
    if (args.length != 1) {
      System.out.println("Usage:");
      System.out.println("java Collatz n");
      System.out.println("where n is the number to test");
      System.exit(1);
    }

    BigInteger n = new BigInteger(args[0]);
    Result res = Collatz.check(n);
    System.out.println("Valid for n="+ n.toString());
    System.out.println("Sequence:");
    for (BigInteger s: res.sequence) {
      System.out.print(s + ", ");
    }
    System.out.println();
  }

  public static boolean getResult(BigInteger n) {
    Result res = Collatz.check(n);
    System.out.println("Valid for n="+ n.toString());
    if (res.bool) {
      return true;
    } else {
      return false;
    }
  }

}

class Result {
  ArrayList<BigInteger> sequence;
  boolean bool = false;
  Result(ArrayList sequence, boolean bool){
    this.sequence = sequence;
    this.bool = bool;
  }
}
