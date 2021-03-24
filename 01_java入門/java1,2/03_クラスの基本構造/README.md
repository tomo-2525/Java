# 用語の整理
## フィールド
- フィールドとメソッドを合わせてメンバという。
- クラスブロック内に宣言された変数のこと
- thisフィールド名で、このクラスのフィールドであることを明示的に表している。

## メソッド
- オーバーロード（仮引数の個数か型が異なれば、同じ名前のメソッドを複数定義できる）
    - シグネクチャ：メソッド名　OR 引数の個数、型、並び順のこと

## コンストラクタ
- インタンス生成時、必ずコンストラクタを呼び出す
- コンストラクタ名はclass名と一緒でなければいけない
- コンストラクタは、定義しなくも良い。定義しない場合は、デフォルトコンストラクタ（引数、操作なしのコンストラクタ）を呼び出す
- 複数のコンストラクタを定義する場合
	- コンストラクタとクラス名は同じじゃないとダメだからオーバーロードになる
	- コンストラクタから別のコンストラクタを呼び出すことは出来るが書き方がわかる
```java
class hoge{
    double a, b;

    hoge(int a, int b){  //1つ目のコンストラクタ
    this.a = a;
    this.b = b;
    }

    hoge(double a, double b){　//２つ目のコンストラクタ
    this.a = a;
    this.b = b;
    }

}
```
```java
//コンストラクタ１
Hero (String name){
	this.hp=100;
	this.name = name;
}

//コンストラクタ２
//コンストラクタ１を呼び出す
Hero(){this("ダミー")}
```

があり、以下のように呼び出すと2つ目のコンストラクタが呼び出される

```java
hoge tmp = new hoge(1.4, 3.2);
```

# メンバの利用方法
- フィールド
`インスタンス名.フィールド名`
- メソッド
`インスタンス名.メソッド名();`

# フィールド、コンストラクタ、メソッドの具体例
```java
class Car {
    //フィールド：このクラスが持っている変数のこと
	int horsePower;
	int speed;
	int fuelConsumption;
	int gasTank;
	int travelledtime;

    //コンストラクタ：インタンス生成時にインタンスを初期化するのに用いる
	Car() {
		this.horsePower = 100;
		this.speed = 0;
		this.fuelConsumption = 22;
		this.gasTank = 45;
		this.travelledtime = 15;
	}

     //メソッド：フィールドなどを操作したり、表示したりする
	void speedUp(int increment) {
		speed = speed + increment;
	}

	void applyBrakes(int decrement) {
		speed = speed - decrement;
	}

	void travelledTimeUp(int increment) {
		travelledtime = travelledtime + increment;
	}

	void printStateTank() {
		int distance = speed * travelledtime;
		int usedfuel = distance / fuelConsumption;
		System.out.println(gasTank - usedfuel);
	}

}

class CarDemo {
	public static void main(String[] args) {

        //インスタンス生成
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();

		//メソッド使用
		car1.speedUp(3);
		car2.speedUp(4);
		car3.speedUp(5);

		car1.travelledTimeUp(2);
		car2.travelledTimeUp(3);
		car3.travelledTimeUp(1);

		car1.printStateTank();
		car2.printStateTank();
		car3.printStateTank();
	}
}
```