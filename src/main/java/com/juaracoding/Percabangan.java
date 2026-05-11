package com.juaracoding;

import java.util.Scanner;

public class Percabangan {

    public static void main(String[] args) {

        if (true) {
            System.out.println("Statment");
        }
        System.out.println("Next Statement");

        // if else
        int plateNumber = 4568;
        if (plateNumber % 2 == 0) { // 0 == 0 -> true
            System.out.println("Nomor plat genap");
        } else {
            System.out.println("Nomor plat ganjil");
        }

        int stock = 55;
        int qty = 60;
        int minRequest = 1; // minimal pembelian 1
        if (qty <= stock) {
            System.out.println("Clickable tombol beli");
            if (qty >= minRequest) {
                System.out.println("Bisa checkout");
            } else {
                System.out.println("Minimal pembelian tidak terpenuhi");
            }
        } else {
            System.out.println("Stok tidak mencukupi");
            System.out.println("Not Clickable tombol beli");
        }

        // else if
        String kurir = "JNE";
        int harga = 0;
        if (kurir == "JNE") {
            harga = 10000;
        } else if (kurir == "Pos") {
            harga = 15000;
        } else if (kurir == "Sicepat") {
            harga = 20000;
        } else {
            System.out.println("Kurir tidak ditemukan");
        }

        System.out.println("Harga: " + harga);

        kurir = "Pos";
        System.out.println(kurir.toUpperCase());
        System.out.println(kurir.toLowerCase());

        int score = 85;
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }

        // switch case
        String voucher = "B12";
        double discount = 0;
        switch (voucher) {
            case "B12":
                System.out.println("Voucher B12");
                System.out.println("Diskon 12%");
                discount = 0.12;
                break;
            case "JNE50":
                System.out.println("Voucher JNE50");
                System.out.println("Diskon 50%");
                discount = 0.50;
                break;
            default:
                System.out.println("Voucher tidak ditemukan");
        }
        System.out.println("Harga akhir: " + (harga - (harga * discount)));

        int pilih = 1;

        switch (pilih) {
            case 1:
                System.out.println("Get All Data Karyawan");
                // panggil method getAll() pada class Karyawan
                break;
            case 2:
                System.out.println("Add Data Karyawan");
                break;
            case 3:
                System.out.println("Update Data Karyawan");
                break;
            default:
                System.out.println("Menu tidak ditemukan");
        }

        // ternary operator
        int nilai = 85;
        String hasil = nilai >= 75 ? "Lulus" : "Gagal";
        System.out.println(hasil);

        String hargaBarang = "Rp11.999.000";
        String clearHarga = hargaBarang.replace("Rp", "").replace(".", "");
        int intHarga = Integer.parseInt(clearHarga);
        System.out.println(intHarga);

        // username password
        Scanner scanner = new Scanner(System.in);
        String username = "admin";
        String password = "Indonesia";
        System.out.println("Masukan username: ");
        String inputUsername = scanner.nextLine();
        System.out.println("Masukan password: ");
        String inputPassword = scanner.nextLine();
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login berhasil");
        } else {
            System.out.println("Login gagal");
        }
        scanner.close();

    }

}