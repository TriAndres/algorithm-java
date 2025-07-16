package ru.practicum;

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String line = reader.readLine();
            String[] arr = line.split(" +");
            int p1 = Integer.parseInt(arr[0]);
            int v1 = Integer.parseInt(arr[1]);
            int c1 = Integer.parseInt(arr[2]);
            int s = Integer.parseInt(arr[3]);

            if ((p1 < 1 || p1 > 100) || (v1 < 1 || v1 > 100) || (c1 < 1 || c1 > 100) || (s < 1 || s > 100)) {
                System.err.println("Ошибка: Число должно находиться в диапазоне от 1 до 100.");
                return;
            }

            if (s <= v1) {
                writer.write(p1);
            } else {
                long totalCost = p1 + ((long)(s - v1)) * c1;
                writer.write(String.valueOf(totalCost));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}