package com.juaracoding;

import java.util.Scanner;

public class Array2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] harga = new int[5];
        int pilih;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1. Add Data Harga");
            System.out.println("2. Total Data Harga");
            System.out.println("3. Average Data Harga");
            System.out.println("4. Find Data Harga Termahal");
            System.out.println("5. Find Data Harga Termurah");
            System.out.println("0. Exit");
            System.out.print("Pilih menu: ");
            pilih = scanner.nextInt();

            switch (pilih) {
                // INPUT DATA
                case 1:
                    for (int i = 0; i < harga.length; i++) {
                        System.out.print("Input harga ke " + (i + 1) + ": ");
                        harga[i] = scanner.nextInt();
                    }
                    System.out.println("Data berhasil disimpan");
                    break;

                // SUM
                case 2:
                    int total = 0;
                    for (int i : harga) {
                        total += i;
                    }
                    System.out.println("Total harga: " + total);
                    break;

                // AVG
                case 3:
                    int sum = 0;
                    for (int i : harga) {
                        sum += i;
                    }
                    double avg = (double) sum / harga.length;
                    System.out.println("Rata-rata harga: " + avg);
                    break;

                // MAX
                case 4:
                    int max = harga[0];
                    for (int i = 1; i < harga.length; i++) {
                        if (harga[i] > max) {
                            max = harga[i];
                        }
                    }
                    System.out.println("Harga termahal: " + max);
                    break;

                // MIN
                case 5:
                    int min = harga[0];
                    for (int i = 1; i < harga.length; i++) {
                        if (harga[i] < min) {
                            min = harga[i];
                        }
                    }
                    System.out.println("Harga termurah: " + min);
                    break;

                case 0:
                    System.out.println("Keluar");
                    break;

                default:
                    System.out.println("Menu Invalid");
            }
        } while (pilih != 0);
        scanner.close();
    }
}