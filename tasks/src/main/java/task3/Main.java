package task3;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = "";

        while (!Objects.equals(line = scanner.nextLine(), "exit")) {
            try {
                RegistrationNumber number = RegistrationNumberParser.Parse(line);
                System.out.println("Введен номер: " + number);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }

    }
}
