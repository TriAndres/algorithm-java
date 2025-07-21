package ru.practicum;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String line = reader.readLine();
            String[] arr = line.split("");
            int n = Integer.parseInt(arr[0]);


            if (n == 1) {
                writer.write(String.valueOf(0));
            } else {
                double value = Math.log(n) / Math.log(2);
                int min = (int) Math.ceil(value);

                writer.write(String.valueOf(min));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}