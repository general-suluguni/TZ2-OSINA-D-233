package test.java;

import main.java.Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Speed_Test {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        System.out.println("Введите необходимое количество чисел в файле: ");
        Scanner scan = new Scanner(System.in);
        int len = 0;
        try {
            len = scan.nextInt();
        }
        catch (NumberFormatException ex) {
            System.out.println("Введено некорректное число: " + ex.getMessage());
        }
        for (int i = 0; i < len; i++) {
            numbers.add(random.nextInt(-1000, 1000));
        }
        String testfile_name = "speed_test.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testfile_name))) {
            for (Integer num : numbers) {
                writer.write(num.toString());
                writer.write(" ");
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при записи файла: " + ex.getMessage());
        }
        System.out.println("Тестовый файл успешно создан!");
        long t_start = System.currentTimeMillis();
        Main.func("speed_test.txt");
        long t_finish = System.currentTimeMillis();
        long time  = (t_finish - t_start);
        System.out.println("Время выполнения программы составило " + time + " миллисекунд.");
    }
}