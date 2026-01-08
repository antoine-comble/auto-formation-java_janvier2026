package main.com.zenika.tp.java;

import java.util.List;
import java.util.stream.Collectors;

public class Exercises {

    public static int diff21(int n) {
        int diff = 21 - n;
        if (n > 21) {
            diff = n - 21;
        }

        return diff;
    }

    /*
     * Nous avons un perroquet qui parle fort.
     * Le paramètre « heure » correspond à l'heure actuelle (de 0 à 23).
     * Un problème survient si le perroquet parle et qu'il est avant 7 h ou après 20 h.
     * Retournez vrai si un problème se produit.
     */
    public static boolean parrotTrouble(boolean talking, int hour) {
        if (hour < 0 || hour > 23) {
            return false;
        }
        return talking && (hour < 7 || hour > 20);
    }

    /*
     * Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.
     */
    public static boolean makes10(int a, int b) {
        return ((a == 10 || b == 10 || (a + b == 10)));
    }

    /*
     * Given a list of integers, return a list where each integer is multiplied by 2.
     */
    public static List<Integer> doubling(List<Integer> nums) {
        //IntStream.range(0, nums.size()).forEach(i -> nums.set(i, nums.get(i) * 2));

        return nums.stream().map(n -> n * 2).collect(Collectors.toList());
    }

    /*
     * Given a list of strings, return a list where each string has "*" added at its end.
     */
    public static List<String> addStar(List<String> strings) {
        return strings.stream().map(n -> n + "*").collect(Collectors.toList());
    }

    /*
     * Given a list of strings, return a list where each string is replaced by 3 copies of the string concatenated together.
     */
    public static List<String> copies3(List<String> strings) {
        return strings.stream().map(n -> n.repeat(3)).collect(Collectors.toList());
    }

    /*
     * Given a list of integers, return a list where each integer is added to 1 and the result is multiplied by 10.
     */
    public static List<Integer> math1(List<Integer> nums) {
        return nums.stream().map(n -> (n + 1) * 10).collect(Collectors.toList());
    }

    /*
     * Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)
     */
    public static List<Integer> rightDigit(List<Integer> nums) {
        return nums.stream().map(n -> n % 10).collect(Collectors.toList());
    }

    /*
     * Given a list of strings, return a list where each string has all its "x" removed.
     */
    public static List<String> noX(List<String> strings) {
        return strings.stream().map(n -> n.toLowerCase().replaceAll("x", "")).collect(Collectors.toList());
    }

    /*
     * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
     * Compute the result recursively (without loops).
     */
    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    /*
     * We have a number of bunnies and each bunny has two big floppy ears.
     * We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
     */
    public static int bunnyEars(int bunnies) {
        if (bunnies == 0) return 0;
        return bunnyEars(bunnies - 1) + 2;
    }

    /*
     * The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
     * The first two values in the sequence are 0 and 1 (essentially 2 base cases).
     * Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
     * Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
     */
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
     * We have bunnies standing in a line, numbered 1, 2, ...
     * The odd bunnies (1, 3, ..) have the normal 2 ears.
     * The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
     * Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
     */
    public static int bunnyEars2(int bunnies) {
        if (bunnies == 0) return 0;
        if (bunnies % 2 == 0) {
            return bunnyEars2(bunnies - 1) + 3;
        } else {
            return bunnyEars2(bunnies - 1) + 2;
        }
    }

    /*
     * We have triangle made of blocks.
     * The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on.
     * Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
     */
    public static int triangle(int rows) {
        if (rows == 0) return 0;
        return rows + triangle(rows - 1);
    }

    /*
     * Given a non-negative int n, return the sum of its digits recursively (no loops).
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     */
    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return sumDigits(n / 10) + (n % 10);
    }

    /*
     * Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2 (no loops).
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     */
    public static int count7(int n) {
        if (n == 0) return 0;
        int result = count7(n / 10);
        if (n % 10 == 7) return result + 1;
        return result;
    }
}
