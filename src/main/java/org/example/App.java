package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        task("Task 1");
//        task("Task 2");
//        task("Task 3");
//        long end = System.currentTimeMillis();
//        System.out.println("Total time (with out threads): " + (end - start) + " ms");

        Thread t1 = new Thread(() -> task("Task 1"));
        Thread t2 = new Thread(() -> task("Task 2"));
        Thread t3 = new Thread(() -> task("Task 3"));
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time (with threads): " + (end - start) + " ms");
    }

    public static void reverseString(String input) {
        String output = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            output = output + input.charAt(i);
        }
        System.out.println("Reversed String: " + output);
    }

    public static String reverseWithStringBUilder(String input) {
        String output = new StringBuilder(input).reverse().toString();
        return output;
    }

    public static void swapStringsWithTemp() {
        String strOne = "Gai";
        String strTwo = "Chana";
        String temp = strOne;
        strOne = strTwo;
        strTwo = temp;
        System.out.println("Swapped Strings: " + strOne + ", " + strTwo);

    }

    public static void swapStringsWithoutTemp() {
        String strOne = "Gai";
        String strTwo = "Chana";
        strOne = strOne + strTwo; // Concatenate both strings
        strTwo = strOne.substring(0, strOne.length() - strTwo.length());
        strOne = strOne.substring(strTwo.length());
        System.out.println("Swapped Strings: " + strOne + ", " + strTwo);

    }

    public static void fibonacciSeries() {
        int n = 10; // number of terms to print
        int first = 0, second = 1;

        System.out.println("Fibonacci Series up to " + n + " terms:");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }
    }

    //character count
    public static void characterCount() {
        String input = "Unibit Games";
        int count = 0;

        // Convert string to character array
        char[] characters = input.toCharArray();

        // Loop through each character and count
        for (char c : characters) {
            if (c != ' ') { // Ignore spaces
                count++;
            }
        }

        System.out.println("Total number of characters (excluding spaces): " + count);
    }

    public static void dublicateCheck() {
        String input = "Unibet Games";
        input = input.toLowerCase().replaceAll(" ", "");

        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : input.toCharArray()) {

            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) + 1);
            } else {
                countMap.put(ch, 1);
            }

        }
        System.out.println("Character count: " + countMap);

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Character '" + entry.getKey() + "' is duplicated " + entry.getValue() + " times.");
            }
        }
//        Integer number = 1233268;
//
//        int[] digits = String.valueOf(number)
//                .chars()
//                .map(c -> c - '0')
//                .toArray();
//
//        Map<Integer, Integer> integerMap = new HashMap<>();
//        for (int i : digits) {
//            if (integerMap.containsKey(i)) {
//                integerMap.put(i, integerMap.get(i) + 1);
//            } else {
//                integerMap.put(i, 1);
//            }
//        }
//        System.out.println(integerMap);
//        for (Map.Entry<Integer,Integer> entry : integerMap.entrySet()){
//            if (entry.getValue()>1){
//                System.out.println(entry.getKey() +"=>"+ entry.getValue());
//            }
//        }


    }

    public static void findSecondLargest() {
        int[] numbers = {12, 35, 1, 10, 34, 1};
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("The second largest element is: " + secondLargest);
        }
    }

    public static void findMissingNumbers() {
        int[] a = {1, 2, 3, 5};
        int n = 5;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : a) {
            actualSum += num;
        }

        int missing = expectedSum - actualSum;
        System.out.println("Missing Number: " + missing);

    }

    public static void swapNumbers() {
        int a = 10;
        int b = 20;


        // Using arithmetic operations
        a = a + b; // a now becomes 30
        b = a - b; // b becomes 10 (30 - 20)
        a = a - b; // a becomes 20 (30 - 10)

        System.out.println("After Swap: a = " + a + ", b = " + b);
    }

    public static void task(String name) {
        try {
            Thread.sleep(1000); // simulate 1 second task
            System.out.println(name + " completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Map<Character, Integer> frequenvyOfChakracters(String input){
        Map<Character , Integer> stringMap= new HashMap<>();
        for (char c : input.toCharArray()){
            stringMap.put(c, stringMap.getOrDefault(c,0)+1);
            return  stringMap;
        }
        return stringMap;
    }


}

