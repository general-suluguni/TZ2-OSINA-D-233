package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;
import main.java.Main;
public class MainTest {
    @Test
    public void test_min() {
        int[] numlist = {1, -3, 100, -999, 10000, 666};
        ArrayList<Long> numbers = new ArrayList<>();
        for (int num : numlist) {
            numbers.add((long) num);
        }
        long output = Main._min(numbers);
        assertEquals(-999, output);
    }

    @Test
    public void test_max() {
        int[] numlist = {-1, 3, 0, -100, 69, 100000};
        ArrayList<Long> numbers = new ArrayList<>();
        for (int num : numlist) {
            numbers.add((long) num);
        }
        long output = Main._max(numbers);
        assertEquals(100000, output);
    }

    @Test
    public void test_sum() {
        int[] numlist = {1, 0, -1, 7, 700, 70};
        ArrayList<Long> numbers = new ArrayList<>();
        for (int num : numlist) {
            numbers.add((long) num);
        }
        String output = Main._sum(numbers);
        long res = -1;
        if (! output.isEmpty()) {
            res = Long.valueOf(output);
        }
        assertEquals(777, res);
    }

    @Test
    public void test_mult() {
        int[] numlist = {2, 3, -1, -5, 5, 10};
        ArrayList<Long> numbers = new ArrayList<>();
        for (int num : numlist) {
            numbers.add((long) num);
        }
        String output = Main._mult(numbers);
        long res = -1;
        if (! output.isEmpty()) {
            res = Long.valueOf(output);
        }
        assertEquals(1500, res);
    }

    @Test
    public void combined_test() {
        int[] numlist = {-99, -1, 0, 2, 3, 5};
        ArrayList<Long> numbers = new ArrayList<>();
        for (int num : numlist) {
            numbers.add((long) num);
        }
        long outp_min = Main._min(numbers); // -99
        long outp_max = Main._max(numbers); // 5
        String outp_sum = Main._sum(numbers); // -90
        String outp_mult = Main._mult(numbers); // 0
        long l_outp_sum = -1;
        long l_outp_mult = -1;
        if (! outp_sum.isEmpty()) {
            l_outp_sum = Long.valueOf(outp_sum);
        }
        if (! outp_mult.isEmpty()) {
            l_outp_mult = Long.valueOf(outp_mult);
        }
        long res = (outp_min - l_outp_sum) * outp_max + l_outp_mult;
        assertEquals(-45, res);
    }

    @Test
    public void speed_test() {
        ArrayList<Long> numbers = new ArrayList<>();
        int len = 1_000_000;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                numbers.add((long)1);
            }
            else {
                numbers.add((long)-1);
            }
        }
        String testfile_name = "speed_test.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testfile_name))) {
            for (Long num : numbers) {
                writer.write(num.toString());
                writer.write(" ");
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при записи файла: " + ex.getMessage());
        }
        long t_start = System.currentTimeMillis();
        Main.func("speed_test.txt");
        long t_finish = System.currentTimeMillis();
        long time  = (t_finish - t_start);
        assertTrue(time >= 0);
        assertEquals(-1, Main._min(numbers));
        assertEquals(1, Main._max(numbers));
        long sum = Long.valueOf(Main._sum(numbers));
        long mult = Long.valueOf(Main._mult(numbers));
        assertEquals(0, sum);
        assertEquals(1, mult);
        }
    }