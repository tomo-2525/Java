# 仮引数と引数の違い
メソッドを呼び出した時に、仮引数に渡されるのは変数のコピーであり`アドレス`ではない
なので、仮引数の値を変更しても、元々の値は変わらない

# 実際の例
以下のプログラムを実行した時、次のような出力になる
`main: k= 5
myMethod: k= 5
myMethod: k= 100
main: k= 5`


```java
public class PrimitiveCall {
  public static void myMethod(int k) {
    System.out.println("myMethod: k= " + k); //k=5
    k = 100;
    System.out.println("myMethod: k= " + k); //k=100
  }

  public static void main(String argv[]) {
    int k = 5;
    System.out.println("main: k= " + k);//k=5
    myMethod(k);
    System.out.println("main: k= " + k);//k=5
  }
}
```