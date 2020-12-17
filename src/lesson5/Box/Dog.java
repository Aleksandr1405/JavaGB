package lesson5.Box;

public class Dog extends Animal {

    public Dog (String type, String name, int run, int swim, float jump) {
        super(type, name, run, swim, jump);
    }

    public void run(int distance) {
        if ( run > 500) {
            System.out.println("Слишком много");
        } else {
            System.out.println(name + " Побежала!");
        }
    }

    public void swim(int distance) {
        if ( swim > 10) {
            System.out.println("Слишком много");
        } else {
            System.out.println(name + " Побежала!");
        }
    }

    public void jump(float height ) {
        if ( height > 0.5) {
            System.out.println("Слишком много");
        } else {
            System.out.println(name + " Побежала!");
        }
    }
}
