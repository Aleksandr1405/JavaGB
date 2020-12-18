package lesson5.Box;

public class Cat extends Animal {

    public Cat (String type, String name, int run, int swim, float jump) {
        super(type, name, run, swim, jump);
    }

    public void run(int distance) {
        if ( run > 200) {
            System.out.println("Слишком много");
        } else {
            System.out.println(name + " Побежала!");
        }
    }

    public void jump(float height ) {
        if ( height > 2) {
            System.out.println("Слишком много");
        } else {
            System.out.println(name + " перепрыгнул!");
        }
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }
}
