package com.juaracoding;

import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class Variable {

    public static void main(String[] args) {

        int num = 10;
        System.out.println(num);

        byte minRequest = 1;
        short stock = 10000;
        //int price = 200_000_000;
        long saldo = 2_200_000_000L;
        long id = 1212121212111122222L;

        char gender = 'L';
        char grade = 'A';

        String path = "C:\\Users\\Lenovo\\OneDrive\\Gambar\\nvidia.jpg";
        System.out.println(path);

        String title = "D\'Jakarta";
        System.out.println(title);

        boolean isStockAvailable = false;

        // createAt

        // Tanggal Lahir 20 Mei 2000
        LocalDate tanggalLahir = LocalDate.of(2000,05,20);
        LocalDate sekarang = LocalDate.now();
        // Menghitung Selisih
        Period selisih = Period.between(tanggalLahir, sekarang);
        System.out.println("Usia sekarang: "+selisih.getYears()+" tahun "+selisih.getMonths()+" bulan");

        // automatic casting
        short num1 = 32000;
        int num2 = num1;
        System.out.println(num2);

        int price = 1_000_000_000;
        short amount = 5;
        long total = (long) amount * price;
        System.out.printf("Total = %,d%n", total);

        // manual casting
        long num3 = 2_000_000_000L;
        int num4 = (int) num3;
        System.out.println(num4);

        int umur = 81;
        int duplikatUmur = umur;
        duplikatUmur = 1308;
        System.out.println(umur);
        System.out.println(duplikatUmur);

        // menggunakan alamat memory yang sama
        Rectangle kotak = new Rectangle(0, 0, 20, 30);
        Rectangle duplikatKotak = kotak;
        duplikatKotak.setSize(80,90);
        System.out.println(kotak.getSize());
        System.out.println(duplikatKotak.getSize());


    }

}