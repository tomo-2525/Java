# 複数のクラスを用いた開発

# 別のクラスのメソッドを用いる
通常、メソッドはインスタンス化しないと使用することができないが、`static`をつけることによってインタンス化しなくても使用するとができる
mainメソッドにstaticがついているのもこのためである。この修飾語については、第８回やろうと思います。
`違うクラスのメソッドを使用する場合はメソッド名だけでは、呼び出すことはできない`


```java
 public class Hello_world {
  public static void main(String[] args) {
    プログラムをここに記述する
  }
}
```


```java
class CalcLogic{
	public static int tasu(int a, int b){
		return a+b;
	}
	public static int hiku(int a, int b){
		return a-b;
	}
}
```

```java
public class Calc{
	public static void main(String[] args){
	int a = 10;
	int b = 2;

	int total = CalcLogic.tasu(a,b);
	int dleta = CalcLogic.hiku(a,b);

	// int total = tasu(a,b);
	// int dleta = hiku(a,b);

	System.out.println("足すと"+total+"\n引くと"+delta);
	}
}
```

クラス名を書かないと次のようになる
`Calc.java:19: エラー: シンボルを見つけられません
        int total = tasu(a, b);
                    ^
  シンボル:   メソッド tasu(int,int)
  場所: クラス Calc
Calc.java:20: エラー: シンボルを見つけられません
        int delta = hiku(a, b);
                    ^
  シンボル:   メソッド hiku(int,int)
  場所: クラス Calc`

# クラスが増えた場合→各クラスをパッケージにまとめる
  `.java`のファイルにクラスが増えてくるとのJavaのファイルをまとめて扱うことで、扱い易くなる

## クラスをパッケージに所属させる方法
ソースコードの先頭にpackage文を記述する（パッケージに親子関係はない）
`package 所属させたいパッケージ名;`
※パッケージを作成する場合は、そのディレクトリを作成する。
例えば、、、`package hoge.huga.foo`と作成した場合は、`hoge/huga/foo`の階層のディレクトリを作成する必要がある。

```java
package calcapp;
//このファイルはcalcappというディレクトリを作成しその中におく
public class Calsc{
	public static int tasu(int a, int b){
		return a+b;
	}
	public static int hiku(int a, int b){
		return a-b;
}
```

## 別のパッケージにあるクラスを呼び出す
- パッケージが同じだったらクラス名は同じではダメだが、パッケージが異なれば同じクラス名を使っても良い
→クラス名（FQCN＝完全限定クラス名）が異なるので両者を区別できる。
- 長い完全限定クラス名を書くのは大変である。しかし、`import文`を使うことによってFQCN入力の面倒さを軽減できる
※`import文はソースコードの先頭`にかくが、`package 文より後`に記述する
- パッケージを作成する場合は、そのディレクトリを作成する。
例えば、、、`package hoge.huga.foo`と作成した場合は、`hoge/huga/foo`の階層のディレクトリを作成する必要がある。
`import パッケージ名.クラス名;`

```java
//packageしたファイル
ackage calcapp;
public class main{
	public static int tasu(int a, int b){
		return a+b;
	}
	public static int hiku(int a, int b){
		return a-b;
}
```

```java
//FQCN=完全限定クラス名を用いてメソッドを呼び出す
class cal {
	public static void hoge(String[] args){
		int total = calcapp.main.CalcLogic.tasu(a, b);
	}
}
```
```java
//import文を用いてメソッドを呼び出す
//import文を書いた場合でもFQCNで呼び出しても実行はできる
import calcapp;
class cal {
	public static void hoge(String[] args){
		int total = CalcLogic.tasu(a, b);
	}
}
```

# Java APIに含まれる代表的なパッケージ
詳しく知りたい方は、[java API リファレンス](https://docs.oracle.com/javase/jp/8/docs/api/)
- java.lang: Javaに欠かせない重要なクラス群
　`importしなくても自動的にimportされる` 
- java.util: プログラミングを便利にする様々なクラス群
- java.math: 数学に関するクラス群
- java.net: ネットワーク通信などを行うためのクラス群
- java.io: ファイルの読み込みなど、データを逐次処理するためのクラス群