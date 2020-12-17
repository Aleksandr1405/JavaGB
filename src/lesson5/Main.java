package lesson5;

import lesson5.Box.Bird;
import lesson5.Box.Cat;
import lesson5.Box.Dog;

public class Main {
    public static void main(String[] args) {
        Horse horse1 = new Horse("Horse","Bella", 5, 1500, 100 );
        Horse horse2 = new Horse("Horse","Lola", 5, 1500, 100 );

        Cat cat1 = new Cat("Cat","Pushok", 10, 20, 10);

        Bird chizhik = new Bird("Bird","chizhik", 5,  0, (float) 0.2);

        Dog marly = new Dog("Dog","Marly", 400, 300, 20);

        horse1.run(157);
        horse2.jump(20);
        horse1.swim(20);

        cat1.run(14);
        cat1.jump(2);

        chizhik.run(12);
        chizhik.jump(1);

        marly.swim(15);
        marly.jump(2);
        marly.run(30);
    }
}
