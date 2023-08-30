package task1;

public class Tiger extends Animal {
    @Override
    public void run(int distance) {
        if (distance <= 1000)
            System.out.println("Я пробежал " + distance + "м");
        else
            System.out.println("Я пробежал 1000 м и устал..."
                    + " осталось пробежать: "
                    + (distance - 1000) + "м");
    }

    @Override
    public void swim(int distance) {
        if (distance <= 100)
            System.out.println("Я проплыл " + distance + "м");
        else
            System.out.println("Я проплыл 100 м и устал..."
                    + " осталось проплыть: "
                    + (distance - 100) + "м");
    }
}
