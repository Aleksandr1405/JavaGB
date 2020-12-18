package lesson5;

import lesson5.Box.Animal;

public class Horse extends Animal {

    public Horse (String type, String name, int run, int swim, float jump) {
        super(type, name, run, swim, jump);
    }

    public void run(int distance) {
        if ( run > 1500) {
            System.out.println("Слишком много");
        } else {
            System.out.println(name + " Побежала!");
        }

    }

    public void swim(int distance) {
        if ( swim > 100) {
            System.out.println(name + " так много не проплывет");
        } else {
            System.out.println(name + " плывет!");
        }
    }

    public void jump(float height) {
        if ( height > 3) {
            System.out.println("Слишком высоко");
        } else {
            System.out.println(name + " перепрыглул!");
        }
    }
}
