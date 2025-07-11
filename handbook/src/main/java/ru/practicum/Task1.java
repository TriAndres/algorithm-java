package ru.practicum;

import java.io.*;

public class Task1 { // Перестановки
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine());

            if (n < 1 || n > 7) {
                System.err.println("Ошибка: Число должно находиться в диапазоне от 1 до 7.");
                return;
            }

            long permutations = factorial(n);

            writer.write(String.valueOf(permutations));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}