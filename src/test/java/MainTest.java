package test.java;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
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
        long output = Main._sum(numbers);
        assertEquals(777, output);
    }

    @Test
    public void test_mult() {
        int[] numlist = {2, 3, -1, -5, 5, 10};
        ArrayList<Long> numbers = new ArrayList<>();
        for (int num : numlist) {
            numbers.add((long) num);
        }
        long output = Main._mult(numbers);
        assertEquals(1500, output);
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
        long outp_sum = Main._sum(numbers); // -90
        long outp_mult = Main._mult(numbers); // 0
        long res = (outp_min - outp_sum) * outp_max + outp_mult;
        assertEquals(-45, res);
    }
}
