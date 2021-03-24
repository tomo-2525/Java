#　クラス型をフィールドに用いる

```java
//Sword.java
public class Sword {
    String name ;
    int damege =10;;
}
```

```java
//Hero.java
public class Hero{
    String name;
    int hp;
    Sword sword;

    void attack(){
        System.out.println("敵へ"+sword.damege+"へのダメージ");
    }
}
```

```java
//main.java
public class main{
    public static void main(String[] args){
        Sword s = new Sword();
        s.name = "炎の剣";
        s.damege = 10;
        Hero h = new Hero();
        h.name = "ミナト";
        h.name = 100;
        h.sword = s;
        System.out.println("現在の武器"+h.sword.name);
    }
}
```
