package com.juaracoding;

import java.util.Scanner;

public class Perulangan2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String correctEmail = "panji@gmail.com";
        String correctPassword = "panji123";

        int attempts = 0;
        int maxAttempts = 3;
        boolean loggedIn = false;

        System.out.println("=== HALAMAN LOGIN ===");
        while (attempts < maxAttempts && !loggedIn) {

            System.out.print("Masukkan Email: ");
            String inputEmail = scanner.nextLine();
            System.out.print("Masukkan Password: ");
            String inputPassword = scanner.nextLine();

            if (!inputEmail.equals(correctEmail)) {
                System.out.println("Email tidak ditemukan");
                attempts++;
            } else if (!inputPassword.equals(correctPassword)) {
                System.out.println("Password salah");
                attempts++;
            } else {
                System.out.println("Login berhasil!");
                System.out.println("Selamat datang, " + inputEmail);
                loggedIn = true;
            }

            // Sisa percobaan
            if (!loggedIn && attempts < maxAttempts) {
                System.out.println("Sisa percobaan: " + (maxAttempts - attempts));
                System.out.println("===================");
            }
        }

        // Jika gagal 3x
        if (!loggedIn) {
            System.out.println("\nERROR:");
            System.out.println("Akun Anda dikunci sementara");
            System.out.println("Karena 3 kali gagal login");
        }

        scanner.close();
    }
}