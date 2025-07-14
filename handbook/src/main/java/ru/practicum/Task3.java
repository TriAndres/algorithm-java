package ru.practicum;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            System.out.println("Введите n и k:");
            String line = reader.readLine();
            String[] arr = line.split(" +");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);

            if ((n < 1 || n > 4) || (k < 1 || k > 4)) {
                throw new RuntimeException("Ошибка: Число должно находиться в диапазоне от 1 до 7.");
            }

            long combination = factorial(n + k - 1) / (factorial(k) * factorial(n - 1));

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