import java.util.Scanner;

public class ClassifyingToys {

    // int result = 0;

    public static int JudgeTryangle(double a, double b, double c) {
        int ans;
        a *= 100;
        b *= 100;
        c *= 100;

        if (c * c == (a * a + b * b))
            ans = 1;
        else if (c * c > (a * a + b * b))
            ans = 2;
        else
            ans = 3;

        return ans;
    }

    public static void main(String[] args) {
        int i;
        int result;
        double a, b, c;
        double[][] data = { { 0.03, 0.04, 0.05 }, { 3.0, 4.0, 5.0 }, { 0.3, 0.4, 5.0 }, { 2, 3, 4 }, { 5, 12, 13 },
                { 0.5, 1.2, 1.3 }, { 19.0, 19.0, 19.0 }, { 0.9, 4.0, 4.1 } };

        for (i = 0; i < 8; i++) {
            result = JudgeTryangle(data[i][0], data[i][1], data[i][2]);
            if (result == 1)
                System.out.println("right-angled");
            else if (result == 2)
                System.out.println("obtuse");
            else
                System.out.println("acute-angled");

        }

        for (i = 0; i < 3; i++) {

            System.out.println("Please enter the lenghth of the three siedes.");
            Scanner scanner = new Scanner(System.in);

            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();

            result = JudgeTryangle(a, b, c);

            if (result == 1)
                System.out.println("right-angled");
            else if (result == 2)
                System.out.println("obtuse");
            else
                System.out.println("acute-angled");
        }
    }

}
