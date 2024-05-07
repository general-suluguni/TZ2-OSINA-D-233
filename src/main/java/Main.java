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
        func(inp_file_name);
    }
    public static void func(String inp_file_name) {
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
                String sum = _sum(numbers);
                if (! sum.isEmpty()) {
                    System.out.println("Сумма всех чисел в файле: " + sum);
                }
                String mult = _mult(numbers);
                if (! mult.isEmpty()) {
                    System.out.println("Произведение всех чисел в файле: " + mult);
                }
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

public static String _sum(ArrayList<Long> numbers) {
    long sum = 0;
    for (long num : numbers) {
        try {
            sum = Math.addExact(sum, num);
        }
        catch (ArithmeticException ex) {
            System.out.println("Невозможно вычислить сумму: " + ex.getMessage());
            return "";
        }
    }
    String res = String.valueOf(sum);
    return res;
}

public static String _mult(ArrayList<Long> numbers) {
    long mult = 1;
    for (long num : numbers) {
        try {
            mult = Math.multiplyExact(mult, num);
        }
        catch (ArithmeticException ex) {
            System.out.println("Невозможно вычислить произведение: " + ex.getMessage());
            return "";
        }
    }
    String res = String.valueOf(mult);
    return res;
}
}
