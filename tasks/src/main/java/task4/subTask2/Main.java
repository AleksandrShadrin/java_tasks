package task4.subTask2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (InputStream stream = task4.subTask1.Main.class.getResourceAsStream("poem.txt");
             InputStreamReader streamReader = new InputStreamReader(stream)) {
            Scanner scanner = new Scanner(streamReader);
            Queue<String> queue = new ArrayDeque<>();

            try {
                while (true) {
                    queue.add(scanner.nextLine());
                }
            } catch(NoSuchElementException ignored) {

            }

            printPoem(queue);
        }
    }

    public static void printPoem(Queue<String> queue) throws InterruptedException {
        Random random = ThreadLocalRandom.current();

        while (true){
            String line = queue.remove();
            System.out.println(line);

            int seconds = 1 + random.nextInt(2);
            Thread.sleep(seconds * 1000);

            if(queue.poll() == null)
                break;
        }
    }
}
