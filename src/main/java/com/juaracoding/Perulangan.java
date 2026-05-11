package com.juaracoding;

import java.util.Scanner;

public class Perulangan {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) { // 5 < 5 -> false
            System.out.println(i);
        }

        // decrement
        for (int i = 5; i > 0; i--) { // 0 > 0 -> false
            System.out.println(i);
        }

        // 1,3,5,7,9
        for (int i = 1; i <= 10; i += 2) {
            System.out.print(i);
        }

        System.out.println();

        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            i++;
        }

        System.out.println();

        // nested for kotak
        int sisi = 8;
        for (int i = 1; i <= sisi; i++) {
            for (int j = 1; j <= sisi; j++) { // 8 <= 8 -> true
                System.out.print("*");
            }
            System.out.println();
        }

        // segitiga siku-siku
        for (int i = 1; i <= sisi; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // segitiga terbalik
        for (int i = 1; i <= sisi; i++) {
            for (int j = sisi; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        int x = 1;
        while (x < 1) {
            System.out.println("x = " + x);
            x++;
        }

        int y = 1;
        do {
            System.out.println("y = " + y);
            y++;
        } while (y < 1);

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            System.out.println("Masukan angka = ");
            int angka = scanner.nextInt();
            if (angka == 100) {
                break;
            }
            sum += angka;
        }
        System.out.println("Total: " + sum);
        scanner.close();

        // login username password, jika gagal 3 kali maka akun terkunci sementara,
        // hubungi CS

    }

}