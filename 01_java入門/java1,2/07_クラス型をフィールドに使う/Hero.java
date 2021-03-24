public class Hero {
    String name;
    int hp;
    Sword sword;

    void attack() {
        System.out.println("敵へ" + sword.damege + "へのダメージ");
    }
}