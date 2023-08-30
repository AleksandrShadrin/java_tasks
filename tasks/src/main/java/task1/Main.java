package task1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = Stream.generate(() ->
            {
                double bound = ThreadLocalRandom.current().nextDouble();

                if(bound > 0.3 && bound < 0.6)
                    return new Cat();
                else if (bound >= 0.6)
                    return new Dog();
                else
                    return new Tiger();

            }).limit(10).collect(Collectors.toList());

        Map<String, Integer> animalsCounter = new HashMap<String, Integer>();

        for (Animal animal: animals){
            int distance = ThreadLocalRandom.current().nextInt(1000);

            String name = animal.getClass().toString().split("\\.")[1];

            if(animalsCounter.containsKey(name))
                animalsCounter.compute(name, (k, v) -> v + 1);
            else
                animalsCounter.put(name, 1);

            animal.run(distance);
            animal.swim(distance);
            System.out.println();
        }

        animalsCounter
                .forEach((k, v) -> System.out.println(k + " упомянулось " + v + " раз"));
    }
}
