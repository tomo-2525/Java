public class main {
    public static void main(String[] args) {
        Sword s = new Sword();
        s.name = "炎の剣";
        s.damege = 10;
        Hero h = new Hero();
        h.name = "ミナト";
        h.hp = 100;
        h.sword = s;
        System.out.println("現在の武器" + h.sword.name);
    }
}