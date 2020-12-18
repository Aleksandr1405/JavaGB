package lesson5.Box;

public abstract class Animal {

    protected String type;
    protected String name;
    protected int run;
    protected int swim;
    protected float jump;

    public Animal(
            String type,
            String name,
            int run,
            int swim,
            float jump) {
        this.type = type;
        this.name = name;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    String getType() {
        return type;
    }

    String getName() {
        return name;
    }

    int getRun() {
        return run;
    }

    int getSwim() {
        return swim;
    }

    float getJump() {
        return jump;
    }


    protected abstract void run(int distance);

    protected abstract void swim(int distance);

    protected abstract void jump(float height);

}
