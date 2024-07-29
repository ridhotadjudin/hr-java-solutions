package com.hackerrank.multi_sum;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a series of integers separated by spaces:");

        String input = scanner.nextLine();

        String[] numbers = input.split(" ");

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        System.out.println(sum);
    }
}
