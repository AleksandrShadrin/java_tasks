package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationNumber {
    // Регион номера
    private final String region;
    // Буквы номера
    private final String letters;
    // Числа в номере
    private final String numbers;

    public RegistrationNumber(String region, String letters, String numbers) throws IOException {
        this.region = region;
        this.letters = letters;
        this.numbers = numbers;

        for (char character:
             letters.toCharArray()) {
            if(!getAvailableLetters().contains(character))
                throw new IllegalArgumentException("Буква: " + character + " недопустима в номере");
        }

        if(!getAvailableRegions().contains(region))
            throw new IllegalArgumentException("Региона: " + region + " не существует");
    }

    public String getRegion() {
        return region;
    }

    public String getLetters() {
        return letters;
    }

    public String getNumbers() {
        return numbers;
    }

    // Кэш для записей регионов
    private static List<String> availableRegionsCache = null;

    // Возвращает существующие регионы
    public List<String> getAvailableRegions() throws IOException {
        if(availableRegionsCache == null){
            // Считывание регионов
            try (InputStream stream = this.getClass().getResourceAsStream("регионы.txt");
                 InputStreamReader streamReader = new InputStreamReader(stream);
                 BufferedReader bufferedReader = new BufferedReader(streamReader)
            ) {
                availableRegionsCache = bufferedReader
                        .lines()
                        .collect(Collectors.toList());
            }
        }

        return availableRegionsCache;
    }

    // Возвращает допустимые символы для номера
    private List<Character> getAvailableLetters() {
        return Arrays.asList('А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х');
    }

    @Override
    public String toString() {
        return letters.charAt(0) + numbers + letters.substring(1) + region;
    }
}
