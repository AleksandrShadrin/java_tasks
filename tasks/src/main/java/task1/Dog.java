package task1;

public class Dog extends Animal{

    @Override
    public void run(int distance) {
        if (distance <= 500)
            System.out.println("Я пробежала " + distance + "м");
        else
            System.out.println("Я пробежала 500 м и устала..."
                    + " осталось пробежать: "
                    + (distance - 500) + "м");
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10)
            System.out.println("Я проплыла " + distance + "м");
        else
            System.out.println("Я проплыла 10 м и устала..."
                    + " осталось проплыть: "
                    + (distance - 10) + "м");
    }
}
