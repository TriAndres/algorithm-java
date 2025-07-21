package ru.practicum;

import java.io.*;
import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String line = reader.readLine();
            String[] arr = line.split(" +");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);

            boolean[][] memo = new boolean[n + 1][m + 1];

            for (int i = 0; i <= n; ++i) {
                Arrays.fill(memo[i], false); // Изначально считаем все состояния невыигрышными
            }

            writer.write(String.valueOf(solve(n, m, memo) ? "Win" : "Lose"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        private static boolean solve(int n, int m, boolean[][] memo) {
        if (memo[n][m]) return true; // Если уже знаем, что это выигрышная позиция

        // Проверяем возможные ходы
        if ((n >= 1 && !solve(n - 1, m, memo)) ||      // Берём один камень из первого набора
                (m >= 1 && !solve(n, m - 1, memo)) ||      // Берём один камень из второго набора
                (n >= 1 && m >= 1 && !solve(n - 1, m - 1, memo))) {   // Берём камни из обоих наборов

            memo[n][m] = true;  // Это выигрышная позиция
            return true;
        }

        return false;           // Нет хода, приводящего к победе соперника => проигрываем
    }
}