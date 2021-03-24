public class matrix {
    public static void main(String[] args) {
        // //宣言方法１
        // 要素の型[] 配列名；
        // 配列名 = new 要素の型[数字];
        int[] a;
        a = new int[5];

        // //宣言方法２
        // 要素の型[] 配列名 = new 要素の型[数字];
        double[] b = new double[5];

        // //値の代入
        // 配列名[:] = {初期値１, 初期値２, ・・・ };
        a[1] = 1;
        b[2] = 2;
        System.out.println(a[1]); // 1
        System.out.println(b[2]); // 2.0

        // //宣言と値の代入を一緒にする
        // 要素の型[] 配列名 = new 要素の型[]{初期値１, 初期値２, ・・・ };
        // 要素の型[] 配列名 = {初期値１, 初期値２, ・・・ };
        long[] c = new long[] { 1, 2, 3, 4, 5 };
        long[] d = { 1, 2, 3, 4, 5 };

        System.out.println(c[1]); // 2
        System.out.println(d[1]); // 2

        // //宣言方法１
        // 要素の型[][] 配列名；
        // 配列名 = new 要素の型[行数][列数];
        int[][] e;
        e = new int[2][3];

        // //宣言方法２
        // 要素の型[][] 配列名 = new 要素の型[行数][列数];
        double[][] f = new double[3][2];

        // //値の代入
        // 配列名[][] = 初期値１
        e[1][2] = 1;
        f[2][1] = 3;
        System.out.println(e[1][2]); // 1
        System.out.println(f[2][1]); // 3.0

        // //宣言と値の代入を一緒にする
        // 要素の型[][] 配列名 = {
        // {初期値１, 初期値２, ・・・ },
        // {初期値n, 初期値n+1, ・・・ }
        // };

        double[][] g = { { 1, 2, 3, 4 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
        System.out.println(g[1][2]); // 3.0
    }
}
