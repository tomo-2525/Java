# 静的メンバ＝静的フィールド＋静的メソッド
- フィールド
フィールドが格納される領域は個々のインスタンスごとに用意される
インスタンスを生成しないと利用はできない

- 静的フィールド
    宣言方法の先頭に`static`キーワードを追加する
    ```java
    // 例
    static int a;
    ```
    - 静的フィールドの箱はインスタンスではなくクラスに対して1つだけ用意される。
    - 全インスタンスに、箱の分身が準備される  
    - インスタンスを1つも生成しなくても静的フィールドを利用できるようになる`Hero.money`は、インスタンスではなくてクラス上に作られるようになるためである。そのため、クラス変数とも呼ばれる。


```java
class Hero {
    static int money;

    Hero(int money) {
        this.money = money;
    }
}

class main {
    public static void main(String[] args) {

        Hero h1 = new Hero(1);
        Hero h2 = new Hero(2);
        Hero h3 = new Hero(3);

        System.out.println("this is h1 " + h1.money);// 3
        System.out.println("this is h2 " + h2.money);// 3
        System.out.println("this is h3 " + h3.money);// 3
        System.out.println("this is Hero " + Hero.money);// 3
    }
}
```
`h1.money`や`h2.money`という分身の箱に値を代入すれば本物の箱`Hero.money`にその値が代入される

- メソッド
インスタンスを生成しないと利用できない


- 静的メソッド
    - インスタンスを生成しなくても利用できる
    これによって、`public static void main(String[] args){~~~}`は`static`がないと実行できなくなっている
    - メソッド自体がクラスに属するようになる
    静的メソッドは、その実態が各インスタンスではなくクラスに属し、`クラス名.メソッド名();`で呼び出せるようになる
    - インスタンスにメソッドの分身が準備される
   `インスタンス変数名.メソッド名;`で呼び出せる
    - 制約
    静的メソッド中でアクセスできるのは、静的メンバだけ
    静的メソッドの中に記述するコードでは、`static`がついていないフィールドやメソッドは利用できない