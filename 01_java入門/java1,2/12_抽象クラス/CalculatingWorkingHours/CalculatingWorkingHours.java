import java.util.Random;

/* your code */
public class CalculatingWorkingHours {
   public static void main(String[] args) {
      Employee[] e;
      Random rand = new Random();
      e = new Employee[rand.nextInt(500)];
      for (int i = 0; i < e.length; i++) {
         switch (rand.nextInt(4)) {
            case 0:
               e[i] = new Regular();
               break;
            case 1:
               e[i] = new PartTime();
               break;
            case 2:
               e[i] = new Engineer();
               break;
            case 3:
               e[i] = new Manager();
               break;
         }
      }

      int sulaly_sum = 0;
      int i;
      for (i = 0; i < e.length; i++) {
         // System.out.print("a");
         e[i].generateNumberHours();
         sulaly_sum += e[i].getH() * e[i].getW();

      }
      // System.out.println("e is " + e.length );
      System.out.println("This company payment is " + sulaly_sum);

      /* your code */
   } // the end of the main method
} // the end of the class CalculatingWorkingHours
