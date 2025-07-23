package ru.practicum;

import java.io.*;
//no
public class Task6 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String line = reader.readLine();
            String[] arr = line.split(" +");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);

            if (isWinPosition(n, m)) {
                writer.write("Win");
            } else {
                writer.write("Lose");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isWinPosition(int n, int m) {
        return !(n % 3 == 0 && m % 3 == 0); //(Math.abs(n - m)) % 2 != 0 // Проверка условия победы/поражения
    }
}