//FQCN=完全限定クラス名を用いてメソッドを呼び出す
// public class main2 {
//     public static void main(String[] args) {
//         int a = 1;
//         int b = 3;
//         int total = calcapp.main.tasu(a, b);
//         System.out.println("totol  is = " + total);
//     }
// }

// import文を用いてメソッドを呼び出す
import calcapp.main;

public class main2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        int total = main.tasu(a, b);
        System.out.println("totol  is = " + total);
    }
}