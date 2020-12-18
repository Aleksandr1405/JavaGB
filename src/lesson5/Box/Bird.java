package lesson5.Box;

public class Bird extends Animal {

    public Bird (String type, String name, int run, int swim, float jump) {
        super(type,name, run, swim, jump);
    }

    public void run(int distance) {
        if ( run > 5) {
            System.out.println(name + " так много не пробежит");
        } else {
            System.out.println(name + " Побежала!");
        }
    }

    public void jump(float height) {
        if ( height > 0.2) {
            System.out.println("очень высоко");
        } else {
            System.out.println(name + " перепрыгнула!");
        }
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }
}
