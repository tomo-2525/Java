# 抽象クラス
抽象メソッドを1つ以上持つクラスのこと

## 抽象メソッドとは
抽象メソッドとは、メソッド名、引数、返り値の型のみを定義して具体的な実装を継承先がオーバーライドして実装するメソッドのことである。
- 抽象メソッドの制約
    抽象クラスは、newによるインスタンス化が禁止される  

## 抽象メソッドを含むクラスの宣言
```java
アクセス修飾子 abstract class クラス名{
    ・・・
}
```
## 抽象メソッドの宣言方法
```java
アクセス修飾子 abstract 戻り値 メソッド名(引数リスト);
```

## 例
```java
abstract class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    //抽象メソッド
    abstract String getGreeting();

    void greet() {
        System.out.println(getGreeting() + " I'm " + name +".");
    }
}

class JapanesePerson extends Person {
    JapanesePerson(String name) {
        super(name);
    }

   
    //PersonクラスのgetGreeting()をオーバーライド
    String getGreeting() {
        return "こんにちは。";
    }
}

class EnglishPerson extends Person {
    EnglishPerson(String name) {
        super(name);
    }

    //PersonクラスのgetGreeting()をオーバーライド
    String getGreeting() {
        return "Hello.";
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Person japanese = new JapanesePerson("Taro");
        Person american = new EnglishPerson("Tom");
        japanese.greet(); // こんにちは。 I'm Taro.
        american.greet(); // Hello. I'm Tom.
    }
}
```