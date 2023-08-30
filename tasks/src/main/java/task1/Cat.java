package task1;

public class Cat extends Animal{
    @Override
    public void run(int distance) {
        if (distance <= 200)
            System.out.println("Я пробежал " + distance + "м");
        else
            System.out.println("Я пробежал 200 м и устал..."
                    + " осталось пробежать: "
                    + (distance - 200) + "м");
    }

    @Override
    public void swim(int distance) {
        System.out.println("Я не могу плыть ведь я кот.");
    }
}
