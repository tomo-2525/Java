# 継承
`以前作ったクラスと似ているクラスを作成する必要がある場合がある。その類似したクラスを作ることを可能にする機能のこと`  
例えば,Hero(クラスをインスタンス化したオブジェクト)は冒険するにつれて進化していきSuperHero(クラスをインスタンス化したオブジェクト)という職業(オブジェクト)になるとする  
SuperHeroは`fly()`で空を飛ぶことができて`land()`着地できる、Heroができる全ての動作は、SuperHeroもできる

## 継承関係の表現方法
Heroクラスを継承して SuperHeroクラスを作った。このような2つのクラスの関係を継承関係という

Hero        ：親クラス、　スーパークラス、　基底クラス  
(汎化)  
　↑  
(特化)  
SuperHero   ：子クラス、　サブクラス、　　　派生クラス

## 子クラスをインスタンス化した時にどのように作成されるか
SuperHeroをnewすると`Heroクラス`のコンストラクタが動作した後`superHeroクラス`のコンストラクタが動作する。`実は、全てのコンストラクタはその先頭で必ず内部インスタンス部（＝親クラス）`のコンストラクタを呼び出さなければいけない
①親インスタンスが作成される  
②親インスタンスの外側に子インスタンスが作成される  
③JVMによりコンストラクタが呼び出される  
- 親クラスのコンストラクタの呼び出し
`super(引数);`  
よって本来　SuperHeroコンストラクタは次のように記述しなければならない
```java
public superHero(){
    //コンストラクタの先頭にかく
    //super();が書かれない場合は、自動的に挿入される
    super();
    System.out.println("SuperHeroインスタンスが生成されました");
}
```


## 継承を用いたクラスの定義
１つのクラスをベースとして複数の子クラスを定義することも孫クラスやひ孫クラスを定義することもできる。
- 複数のクラスを親として1つの子クラスを定義をすること多重継承というがJavaではできない
- オーバーライド：親クラスのメンバを子クラス側で上書きすること（同じシグネクチャと戻り値を持つ）
- 継承やオーバーライドの禁止
    クラス宣言時に`final`をつけると、そのクラスは継承できない  
    宣言に`final`がつけられたメソッドは子クラスでオーバーライドができない   
```java
class クラス名 extends 元となるクラス名 {
    追加したいメンバ（フィールド＋メソッド）
}
```
## 親子インスタンスの姿と利用方法
継承を用いて定義されたSuperHeroのようなクラスから生まれたインスタンスは実際にどのような姿をしているのか
外から見たら、1つのSuperHeroインスタンスだが内部に、Heroインスタンスがを含んでいて二重構造になっている
- メソッドの呼び出し
    多重構造のインスタンスは、極力、外側にある子インスタンス部分のメソッドに対応しようとする  
    →つまり、SuperHeroインスタンスの中にはHeroインスタンスのフィールドとメソッドが含まれている。Heroクラスを継承しSuperHeroクラスを作成する時、メソッドをオーバーライドした場合に、優先的に呼び出されるメソッドは、SuperHeroインスタンスのオーバーライドしたメソッドになります。

    - 親インスタンス部のフィールドを利用する
    ※祖父母インスタンス部への子クラスからのアクセスはできない
    `super.フィールド名`

    - 親インスタンス部のメソッドを呼び出す
    `super.メソッド名(引数);`
    ```java
    public class SuperHero extends Hero{
        ・・・
        public void attack(Metango m){
            if(this.flying){
                //super.を付けないとthis.attack()と認識されて無限ループになってしまう
                super.attack(m);
            }
        }

    }
    ```


### 例
```java
class Hero{
String name;
int hp;
int damage;

Hero(String name, int hp, int damage){
    this.name = name;
    this.hp = hp;
    this.damage = damage;
}

void attack(){
 System.out.println("敵に"+damage+"の攻撃");
}

}

class SuperHero extends Hero{
    private boolean flying;

    public void fly(){
        this.flying = true;
        System.out.println("飛び上がった");
    }

    public void land(){
        this.flying = false;
        System.out.println("着地した");
    }
}

public class game{
    public static void main(String[] args){
        
    }
}

```