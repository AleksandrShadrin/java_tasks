package task4.subTask1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream stream = Main.class.getResourceAsStream("poem.txt");
             InputStreamReader streamReader = new InputStreamReader(stream)) {
            Scanner scanner = new Scanner(streamReader);
            List<String> data = new ArrayList<>();
            int part = 1;

            try {
                while (true) {
                    String line = scanner.nextLine();
                    // Если пустая строка, то записываем абзац в файл
                    if(line.trim().isEmpty()) {
                        Files.write(Paths.get("part" + part + ".txt"), data, StandardCharsets.UTF_8);
                        data.clear();
                        part++;
                    } else
                        data.add(line);
                }
            } catch(NoSuchElementException exception) {
                Files.write(Paths.get("part" + part + ".txt"), data, StandardCharsets.UTF_8);
                System.out.println("Конец файла.");
            }
        }
    }
}
