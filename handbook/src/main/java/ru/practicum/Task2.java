package ru.practicum;

import java.io.*;

public class Task2 {//Сочетания

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            String line = reader.readLine();
            String[] arr = line.split(" +");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);

            if ((n < 1 || n > 7) || (k < 1 || k > 7)) {
                System.err.println("Ошибка: Число должно находиться в диапазоне от 1 до 7.");
                return;
            }

            long combination = factorial(n) / (factorial(k) * factorial(n - k));

            writer.write(String.valueOf(combination));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }
}