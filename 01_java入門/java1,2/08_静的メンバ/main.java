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