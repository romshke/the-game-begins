import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static String uniqueLetters(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/hyperskill-dataset-117325783.txt");

        try (Scanner scanner = new Scanner(file)) {
            String input = scanner.nextLine();
            System.out.println(uniqueLetters(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
