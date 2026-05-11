package com.juaracoding;

import java.util.Scanner;

public class ATM {
    static Scanner input = new Scanner(System.in);

    /* 
       Jawaban Essay No 3: Manajemen Array
       Kendala: Array memiliki ukuran tetap (fixed-size). Jika ada nasabah baru, 
       kita tidak bisa menambah elemen secara langsung.
       Solusi tanpa ArrayList: Membuat array baru dengan ukuran lebih besar, 
       menyalin data lama ke array baru menggunakan loop atau System.arraycopy(), 
       lalu menambahkan data baru di index terakhir.
    */
    static int[] norek = {101, 102, 103};
    static int[] pin = {1111, 2222, 3333};
    static double[] saldo = {500000, 1000000, 200000};
    static boolean[] isBlocked = {false, false, false};

    public static void main(String[] args) {
        while (true) {
            int userIndex = login();
            if (userIndex != -1) {
                menuATM(userIndex);
            }
            
            // Opsi untuk keluar dari program utama jika diperlukan, 
            // namun soal meminta looping sampai "Exit" (Logout di menu ATM diartikan kembali ke login)
            // Jika "Exit" berarti keluar total, maka kita tambahkan pilihan di luar.
            // Namun biasanya Exit berada di dalam menu.
        }
    }

    static int login() {
        System.out.println("=== LOGIN ATM ===");
        System.out.print("Masukkan No Rekening: ");
        int inputRek = -1;
        
        try {
            inputRek = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
            return -1;
        }

        int userIndex = -1;
        for (int i = 0; i < norek.length; i++) {
            if (inputRek == norek[i]) {
                userIndex = i;
                break;
            }
        }

        if (userIndex == -1) {
            System.out.println("Rekening tidak ditemukan!\n");
            return -1;
        }

        if (isBlocked[userIndex]) {
            System.out.println("Akun Anda terblokir! Silakan hubungi bank.\n");
            return -1;
        }

        // Logic PIN dengan counter maksimal 3x
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Masukkan PIN: ");
            int inputPin = -1;
            try {
                inputPin = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("PIN harus angka!");
                attempts++;
                continue;
            }

            if (inputPin == pin[userIndex]) {
                System.out.println("Login berhasil!");
                return userIndex;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("PIN salah! Sisa percobaan: " + (3 - attempts));
                }
            }
        }

        // Jika sampai sini berarti 3x salah
        isBlocked[userIndex] = true;
        System.out.println("PIN salah 3 kali. Akun Anda telah TERBLOKIR!\n");
        return -1;
    }

    static void menuATM(int index) {
        int pilih = 0;
        do {
            System.out.println("\n=== MENU ATM (Rekening: " + norek[index] + ") ===");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Transfer");
            System.out.println("5. Logout/Exit");
            System.out.print("Pilih menu: ");
            
            try {
                pilih = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid!");
                continue;
            }

            switch (pilih) {
                case 1:
                    cekSaldo(index);
                    break;
                case 2:
                    tarikTunai(index);
                    break;
                case 3:
                    setorTunai(index);
                    break;
                case 4:
                    transfer(index);
                    break;
                case 5:
                    System.out.println("Logout berhasil.\n");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilih != 5);
    }

    static void cekSaldo(int index) {
        System.out.println("Saldo anda: Rp " + saldo[index]);
    }

    // Jawaban Essay No 2: Validasi Pecahan & Minimal Penarikan
    static void tarikTunai(int index) {
        System.out.print("Masukkan jumlah tarik (Kelipatan Rp 50.000): ");
        double jumlah = 0;
        try {
            jumlah = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
            return;
        }

        // Kondisi if untuk kelipatan 50.000 dan minimal penarikan (Pecahan terkecil adalah 50.000)
        if (jumlah % 50000 != 0 || jumlah < 50000) {
            System.out.println("Error: Penarikan harus kelipatan Rp 50.000 dan minimal Rp 50.000!");
            return;
        }

        // Validasi Saldo Minimal tersisa 50.000
        if (saldo[index] - jumlah < 50000) {
            System.out.println("Error: Transaksi dibatalkan! Saldo minimal harus tersisa Rp 50.000.");
        } else {
            saldo[index] -= jumlah;
            System.out.println("Tarik tunai berhasil! Sisa saldo: Rp " + saldo[index]);
        }
    }

    static void setorTunai(int index) {
        System.out.print("Masukkan jumlah setor: ");
        double jumlah = 0;
        try {
            jumlah = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
            return;
        }

        if (jumlah > 0) {
            saldo[index] += jumlah;
            System.out.println("Setor tunai berhasil! Saldo sekarang: Rp " + saldo[index]);
        } else {
            System.out.println("Jumlah tidak valid!");
        }
    }

    // Jawaban Essay No 1: Logika Sinkronisasi Index saat Transfer
    static void transfer(int senderIndex) {
        System.out.print("Masukkan nomor rekening tujuan: ");
        int targetRek = -1;
        try {
            targetRek = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
            return;
        }

        // Linear Search untuk mencari index penerima berdasarkan nomor rekening
        int receiverIndex = -1;
        for (int i = 0; i < norek.length; i++) {
            if (norek[i] == targetRek) {
                receiverIndex = i; // Menemukan index penerima yang benar
                break;
            }
        }

        if (receiverIndex == -1) {
            System.out.println("Error: Nomor rekening tujuan tidak ditemukan!");
            return;
        }

        if (receiverIndex == senderIndex) {
            System.out.println("Error: Tidak bisa transfer ke rekening sendiri!");
            return;
        }

        System.out.print("Masukkan jumlah transfer: ");
        double jumlah = 0;
        try {
            jumlah = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
            return;
        }

        if (jumlah <= 0) {
            System.out.println("Jumlah tidak valid!");
            return;
        }

        // Cek saldo pengirim (Minimal sisa 50.000 jika sesuai aturan umum, 
        // namun soal hanya menyebutkan "Jika saldo kurang, transaksi dibatalkan" 
        // dan "Saldo minimal harus tersisa di akun setelah penarikan adalah Rp 50.000" (poin 2).
        // Kita terapkan aturan saldo minimal yang sama untuk transfer agar aman.)
        if (saldo[senderIndex] - jumlah < 50000) {
            System.out.println("Error: Saldo tidak cukup (Minimal sisa saldo Rp 50.000)!");
        } else {
            saldo[senderIndex] -= jumlah;
            saldo[receiverIndex] += jumlah;
            System.out.println("Transfer berhasil ke Rekening " + norek[receiverIndex] + "!");
            System.out.println("Sisa saldo Anda: Rp " + saldo[senderIndex]);
        }
    }
}