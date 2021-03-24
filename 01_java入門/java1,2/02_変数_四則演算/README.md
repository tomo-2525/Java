# 変数の型

- 基本型（プリミティブ型）
    - 論理型
    boolean
    - 整数型
    byte
    short
    int
    long
    - 浮動小数点型
    float
    double
    - 文字型
    char
- 参照型
※参照型は、値のある場所を保持しているため、nullを代入することができる。nullを代入すると、ガーベージコレクタ（nullが代入されたオブジェクトが使用していたメモリを自動で開放する）が働く。
    - クラス型 →データ（フィールド）と手続き（メソッド）を持つデータ
    自分で作ったクラスはもちろんだが`Object`クラスもしくはそれの子孫クラスや、ラッパークラスと呼ばれる`Integer`, `Float`, `Double`, `Boolean`, `Character`, `Byte`, `Short`, `Long`などもある。`String`もクラス型
    - インターフェース型
    - 配列型

# 変数の宣言方法

`データ型名　変数名；`

 ```java
boolean b;
int i;
double d;
String str;
 ```

## 配列の宣言方法と値の代入

```java
 //宣言方法１
要素の型[] 配列名；
配列名 = new 要素の型[数字];

//宣言方法２
要素の型[] 配列名 = new 要素の型[数字];

//値の代入
配列名[index] = 初期値１; 

//宣言と値の代入を一緒にする
要素の型[] 配列名 = new 要素の型[]{初期値１, 初期値２, ・・・ };
要素の型[] 配列名 = {初期値１, 初期値２, ・・・ };

```
##　多次元配列の宣言方法

```java
 //宣言方法１
要素の型[][] 配列名；
配列名 = new 要素の型[行数][列数];

//宣言方法２
要素の型[][] 配列名 = new 要素の型[行数][列数];

//値の代入
配列名[index][index] = 値；

//宣言と値の代入を一緒にする
要素の型[][] 配列名 = {
            {初期値１, 初期値２, ・・・ },
            {初期値n, 初期値n+1, ・・・ }
};

```

## プリミティブ型と参照型の違い
プリミティブ型は値自身を、参照型は値のある場所を保持する。
例えば、

```java
int a = 1;
int b = 1;
System.out.println(a == b);
```

は`true`が出力されるが、

```java
Integer c = new Integer(1);
Integer d = new Integer(1);
System.out.println(c == d);
```

は`false`が出力されるはず。

これは、`int`同士の `==` での比較は値(この場合だと1)を比較しているが、`Integer`同士の `==` での比較は値のある場所(この場合だと変数cと変数dの
場所)を比較しているため。

# 四則演算
|+|足し算|
----|---- 
|-|引き算|
|*|掛け算|
|/|割り算|
|%|剰余算|

# ビット演算子とビットシフト演算子
```java
&   AND     →   0010 & 0110 //0010
|   OR 　　　→   0010 | 0110 //0110
^   XOR     →   0010 ^ 0110 //0100
~   NOT     →   ~0100 //1011
<<数字  ビットシフト左      →  0001 << 1 //0010
>>数字  ビットシフト右（符号あり） → 0010 >> 1  //0001
>>>数字　ビットシフト右（符号無し）→ 1001 >>> 1 //0100
```

## 代入時の自動変換
「小さな型」の値を「大きな型」の変換に代入する場合に限って値が自動的に型変換されて代入される
`int`, `long`, `byte`, `short`, `float`, `double`同士は明示的なキャストなしに四則演算を行うことができる。
<table style="border-collapse: collapse; width: 100%;">
<tbody>
<tr>
<td style="width: 12.5%; text-align: center;"></td>
<td style="width: 12.5%; text-align: center;" colspan="7">代入先の変数先の型</td>
</tr>
<tr>
<td style="width: 12.5%; text-align: center;" rowspan="7">代入をする値の型</td>
<td style="width: 12.5%; text-align: center;"></td>
<td style="width: 12.5%; text-align: center;">byte</td>
<td style="width: 12.5%; text-align: center;">short</td>
<td style="width: 12.5%; text-align: center;">int</td>
<td style="width: 12.5%; text-align: center;">long</td>
<td style="width: 12.5%; text-align: center;">float</td>
<td style="width: 12.5%; text-align: center;">double</td>
</tr>
<tr>
<td style="width: 12.5%; text-align: center;">byte</td>
<td style="width: 12.5%; text-align: center;">◎</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
</tr>
<tr>
<td style="width: 12.5%; text-align: center;">short</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">◎</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
</tr>
<tr>
<td style="width: 12.5%; text-align: center;">int</td>
<td style="width: 12.5%; text-align: center;">△</td>
<td style="width: 12.5%; text-align: center;">△</td>
<td style="width: 12.5%; text-align: center;">◎</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
</tr>
<tr>
<td style="width: 12.5%; text-align: center;">long</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">◎</td>
<td style="width: 12.5%; text-align: center;">○</td>
<td style="width: 12.5%; text-align: center;">○</td>
</tr>
<tr>
<td style="width: 12.5%; text-align: center;">float</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">◎</td>
<td style="width: 12.5%; text-align: center;">○</td>
</tr>
<tr>
<td style="width: 12.5%; text-align: center;">double</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">×</td>
<td style="width: 12.5%; text-align: center;">◎</td>
</tr>
</tbody>
</table>

◎ ・・・そのまま代入可能

○ ・・・自動型変換により代入可能

△ ・・・例外的に代入可能

× ・・・代入不可能  

# キャスト
キャストとは明示的な型変換のことです。
```java
class hoge {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;

        System.out.println(a / b); //1
        System.out.println((double) a / b); //1.5
    }
}
```