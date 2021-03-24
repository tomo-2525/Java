import java.lang.Math;

import javax.management.MBeanRegistration;

public class LambdaExpressionExercise {
    public static void main(String args[]) {
        LambdaExpressionExercise tester = new LambdaExpressionExercise();
        MathOperation1 power = (double x) -> {
            return x * x * x;
        };
        MathOperation1 squre = (double x) -> {
            return Math.sqrt(x);
        };
        MathOperation2 pow = (double x, double y) -> {
            return Math.pow(x, y);
        };

        MathOperation3 passFailService = (int score) -> {
            if (score >= 70)
                return "Pass";
            else
                return "Fail";
        };
        System.out.println("x=4");
        System.out.println("x * x * x = " + tester.operate(4, power));
        System.out.println("x's squre root = " + tester.operate(4, squre));

        System.out.println("x=2, y=3");
        System.out.println("x to the power y = " + tester.operate(2, 3, pow));
        System.out.println("passFailService  " + tester.operate(70, passFailService));
        System.out.println("passFailService  " + tester.operate(69, passFailService));
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface MathOperation1 {
        double operation(double x);
    }

    interface MathOperation2 {
        double operation(double x, double y);
    }

    interface MathOperation3 {
        String operation(int score);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    private double operate(double x, MathOperation1 mathOperation) {
        return mathOperation.operation(x);
    }

    private double operate(double x, double y, MathOperation2 mathOperation) {
        return mathOperation.operation(x, y);
    }

    private String operate(int score, MathOperation3 mathOperation) {
        return mathOperation.operation(score);
    }

}