import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        System.out.println("Введите необходимое количество чисел в файле: ");
        Scanner scan = new Scanner(System.in);
        try {
            int len = scan.nextInt();
            for (int i = 0; i < len; i++) {
                numbers.add(random.nextInt());
            }
            String testfile_name = "generated_test.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(testfile_name))) {
                for (Integer num : numbers) {
                    writer.write(num.toString());
                    writer.write(" ");
                }
            } catch (IOException ex) {
                System.err.println("Ошибка при записи файла: " + ex.getMessage());
            }
            System.out.println("Тестовый файл успешно создан!");
        }
        catch (NumberFormatException ex) {
            System.out.println("Введено некорректное число: " + ex.getMessage());
        }
    }
}
