package task3;

import java.io.IOException;
import java.util.*;

public class RegistrationNumberParser {

    // Парсит строку в регистрационный номер
    public static RegistrationNumber Parse(String line) throws IOException {
        // Удаляем пробелы и rus из строки, после чего переводим её в верхний регистр
        String redactedLine = line.replaceFirst("[rR][uU][sS]", "")
                .replace(" ", "")
                .toUpperCase();

        if (redactedLine.length() < 8
            || redactedLine.length() > 9)
            throw new IllegalArgumentException(line + " : не может формировать номер.");

        // Записываем символы в очередь, чтобы последовательно их извлекать
        Queue<Character> symbols = toQueue(line);

        String letters = "";
        String numbers = "";
        String region = "";

        letters += symbols.remove();

        numbers += symbols.remove();
        numbers += symbols.remove();
        numbers += symbols.remove();

        letters += symbols.remove();
        letters += symbols.remove();

        region += symbols.remove();
        region += symbols.remove();

        // Если регион трехзначный
        if (redactedLine.length() == 9)
            region += symbols.remove();

        return new RegistrationNumber(region, letters, numbers);
    }

    private static Queue<Character> toQueue(String line) {
        Queue<Character> result = new ArrayDeque<>();

        for (Character character:
             line.toCharArray()) {
            result.add(character);
        }

        return result;
    }
}
