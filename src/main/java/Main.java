package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите расположение файла: ");
        String inp_file_name = scan.next();
        try {
            FileReader fileReader = new FileReader(inp_file_name);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inp_line = bufferedReader.readLine();
            String[] contents = inp_line.split(" ");
            ArrayList<Long> numbers = new ArrayList<>();
            for (String content : contents) {
                try {
                    long number = Long.parseLong(content);
                    numbers.add(number);
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Некорректный формат содержимого - данный элемент не будет считан: " + numberFormatException.getMessage());
                }
            }
            if (numbers.isEmpty()) {
                System.out.println("Файл пуст, либо в нём нет считываемых элементов.");
            }
            else {
                System.out.println("Минимальное число в файле: " + _min(numbers));
                System.out.println("Максимальное число в файле: " + _max(numbers));
                System.out.println("Сумма всех чисел в файле: " + _sum(numbers));
                System.out.println("Произведение всех чисел в файле: " + _mult(numbers));
            }
        } catch (IOException file_reading_ex) {
            System.out.println("Произошла ошибка при считывании файла: " + file_reading_ex.getMessage());
            System.exit(0);
        }
    }
public static long _min(ArrayList<Long> numbers) {
    long min = Long.MAX_VALUE;
    for (long num : numbers) {
        if (num < min) {
            min = num;
        }
    }
    return min;
}

public static long _max(ArrayList<Long> numbers) {
    long max = Long.MIN_VALUE;
    for (long num : numbers) {
        if (num > max) {
            max = num;
        }
    }
    return max;
}

public static long _sum(ArrayList<Long> numbers) {
    long sum = 0;
    for (long num : numbers) {
        sum = Math.addExact(sum, num);
    }
    return sum;
}

public static long _mult(ArrayList<Long> numbers) {
    long mult = 1;
    for (long num : numbers) {
        mult = Math.multiplyExact(mult, num);
    }
    return mult;
}
}
